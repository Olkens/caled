package com.reopen.calendar.services

import com.reopen.calendar.domain.TrainerProfile
import com.reopen.calendar.dto.trainer.TrainerSaveRequestDTO
import com.reopen.calendar.dto.trainer.TrainersGETRequestDTO
import com.reopen.calendar.dto.trainer.TrainersGETResponseDTO
import com.reopen.calendar.dto.trainer.TrainersPOSTResponseDTO
import com.reopen.calendar.mappers.trainers.TrainerMapper
import com.reopen.calendar.repositories.TrainerRepository
import com.reopen.calendar.repositories.TrainingCategoryRepository
import com.reopen.calendar.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class TrainerService(
    private val trainerRepository: TrainerRepository,
    private val trainerMapper: TrainerMapper,
    private val userRepository: UserRepository,
    private val trainingCategoryRepositry: TrainingCategoryRepository
) {

    fun findByCategories(dto: TrainersGETRequestDTO): List<TrainersGETResponseDTO> {
        val trainers = when {
            dto.categoryIds.isNotEmpty() ->
                trainerRepository.findByCategoryIds(dto.categoryIds)

            dto.categoryNames.isNotEmpty() ->
                trainerRepository.findByCategoryNames(dto.categoryNames)

            else -> trainerRepository.findAll()
        }
        return trainerMapper.toResponseDTOList(trainers)
    }

    fun saveTrainer(dto: TrainerSaveRequestDTO): TrainersPOSTResponseDTO {
        val user = userRepository.findById(dto.userId)
            .orElseThrow { NoSuchElementException("User not found with id: ${dto.userId}") }

        val categories = trainingCategoryRepositry.findAllById(dto.categoryIds).toMutableList()

        val trainerProfile = TrainerProfile(
            user = user,
            categories = categories,
            yearsOfExperience = dto.yearsOfExperience
        )

        val saved = trainerRepository.save(trainerProfile)

        return TrainersPOSTResponseDTO(
            id = saved.id,
            userId = saved.user.id,
            categoryIds = saved.categories.map { it.id },
            yearsOfExperience = saved.yearsOfExperience,
            pricePerHour = saved.pricePerHour
        )
    }
}
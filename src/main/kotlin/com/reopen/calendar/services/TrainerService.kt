package com.reopen.calendar.services

import com.reopen.calendar.domain.TrainerProfile
import com.reopen.calendar.dto.trainer.TrainerSaveRequestDTO
import com.reopen.calendar.dto.trainer.TrainersGETResponseDTO
import com.reopen.calendar.dto.trainer.TrainersSaveResponseDTO
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
    private val trainingCategoryRepository: TrainingCategoryRepository
) {

    fun findByCategories(categoryIds: List<Long>?, categoryNames: List<String>?): List<TrainersGETResponseDTO> {
        val trainers = when {
            categoryIds?.isNotEmpty() == true ->
                trainerRepository.findByCategoryIds(categoryIds)

            categoryNames?.isNotEmpty() == true ->
                trainerRepository.findByCategoryNames(categoryNames)

            else -> trainerRepository.findAll()
        }
        return trainerMapper.toResponseDTOList(trainers)
    }

    fun saveTrainer(dto: TrainerSaveRequestDTO): TrainersSaveResponseDTO {
        val user = userRepository.findById(dto.userId)
            .orElseThrow { NoSuchElementException("User not found with id: ${dto.userId}") }

        val categories = trainingCategoryRepository.findAllById(dto.categoryIds).toMutableList()

        val trainerProfile = TrainerProfile(
            user = user,
            categories = categories,
            description = dto.description,
            yearsOfExperience = dto.yearsOfExperience
        )

        val saved = trainerRepository.save(trainerProfile)

        return TrainersSaveResponseDTO(
            id = saved.id,
            userId = saved.user.id,
            categoryIds = saved.categories.map { it.id },
            description = saved.description,
            yearsOfExperience = saved.yearsOfExperience,
            pricePerHour = saved.pricePerHour
        )
    }
}
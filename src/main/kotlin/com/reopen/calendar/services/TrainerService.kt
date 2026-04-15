package com.reopen.calendar.services

import com.reopen.calendar.domain.TrainerProfile
import com.reopen.calendar.dto.trainer.TrainersGETRequestDTO
import com.reopen.calendar.dto.trainer.TrainersGETResponseDTO
import com.reopen.calendar.mappers.trainers.TrainerMapper
import com.reopen.calendar.repositories.TrainerRepository

class TrainerService(
    private val trainerRepository: TrainerRepository,
    private val trainerMapper: TrainerMapper
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
}
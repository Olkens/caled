package com.reopen.calendar.mappers.trainers

import com.reopen.calendar.domain.TrainerProfile
import com.reopen.calendar.dto.category.CategoryDTO
import com.reopen.calendar.dto.trainer.TrainersGETResponseDTO
import com.reopen.calendar.dto.user.UserDataDTO
import org.springframework.stereotype.Component

@Component
object TrainerMapper {

    fun toResponseDTO(trainer: TrainerProfile): TrainersGETResponseDTO =
        TrainersGETResponseDTO(
            id = trainer.id,
            user = UserDataDTO(
                id = trainer.user.id,
                name = trainer.user.name,
                email = trainer.user.email
            ),
            categories = trainer.categories.map { CategoryDTO(it.id, it.name) },
            description = trainer.description,
            yearsOfExperience = trainer.yearsOfExperience,
            pricePerHour = trainer.pricePerHour
        )

    fun toResponseDTOList(trainers: List<TrainerProfile>): List<TrainersGETResponseDTO> =
        trainers.map { toResponseDTO(it) }
}
package com.reopen.calendar.services

import com.reopen.calendar.domain.TrainingCategory
import com.reopen.calendar.dto.category.CategorySaveRequestDTO
import com.reopen.calendar.dto.category.CategorySaveResponseDTO
import com.reopen.calendar.repositories.TrainingCategoryRepository
import org.springframework.stereotype.Service

@Service
class TrainerCategoryService(
    private val trainingCategoryRepository: TrainingCategoryRepository
) {
    fun saveCategory(dto: CategorySaveRequestDTO): CategorySaveResponseDTO {
        val category = TrainingCategory(
            name = dto.name,
            description = dto.description
        )
        val saved = trainingCategoryRepository.save(category)

        return CategorySaveResponseDTO(
            id = saved.id,
            name = saved.name,
            description = saved.description
        )
    }
}
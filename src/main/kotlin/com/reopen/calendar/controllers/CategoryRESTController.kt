package com.reopen.calendar.controllers

import com.reopen.calendar.dto.category.CategorySaveRequestDTO
import com.reopen.calendar.dto.category.CategorySaveResponseDTO
import com.reopen.calendar.services.TrainerCategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/categories")
class CategoryRESTController (
    private val trainerCategoryService: TrainerCategoryService
) {
    @PostMapping("/")
    fun saveCategory(
        @RequestBody dto: CategorySaveRequestDTO
    ): ResponseEntity<CategorySaveResponseDTO> {
        return ResponseEntity.ok(trainerCategoryService.saveCategory(dto))
    }
}
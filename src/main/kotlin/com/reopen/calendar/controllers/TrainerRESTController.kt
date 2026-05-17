package com.reopen.calendar.controllers

import com.reopen.calendar.dto.trainer.TrainerSaveRequestDTO
import com.reopen.calendar.dto.trainer.TrainersGETResponseDTO
import com.reopen.calendar.dto.trainer.TrainersSaveResponseDTO
import com.reopen.calendar.repositories.TrainerRepository
import com.reopen.calendar.services.TrainerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/trainers")
class TrainerRESTController(
    private val trainerService: TrainerService
) {

    @GetMapping("/")
    fun getTrainers(
        @RequestParam(required = false) categoryIds: List<Long>?,
        @RequestParam(required = false) categoryNames: List<String>?
    ): ResponseEntity<List<TrainersGETResponseDTO>> {
        return ResponseEntity.ok(trainerService.findByCategories(categoryIds, categoryNames))
    }

    @PostMapping("/")
    fun saveTrainer(
        @RequestBody dto: TrainerSaveRequestDTO
    ):ResponseEntity<TrainersSaveResponseDTO> {
        return ResponseEntity.ok(trainerService.saveTrainer(dto))
    }
}
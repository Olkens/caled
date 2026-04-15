package com.reopen.calendar.controllers

import com.reopen.calendar.dto.trainer.TrainersGETRequestDTO
import com.reopen.calendar.dto.trainer.TrainersGETResponseDTO
import com.reopen.calendar.services.TrainerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/trainer")
class TrainerRESTController(private val trainerService: TrainerService) {

    @GetMapping("/")
    fun getTrainers(
        @ModelAttribute dto: TrainersGETRequestDTO
        // lub @RequestParam categoryIds: List<Long>
    ): ResponseEntity<List<TrainersGETResponseDTO>> {
        return ResponseEntity.ok(trainerService.findByCategories(dto))
    }

}
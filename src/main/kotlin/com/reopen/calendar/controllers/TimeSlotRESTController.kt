package com.reopen.calendar.controllers

import com.reopen.calendar.domain.TimeSlot
import com.reopen.calendar.dto.timeslot.TimeSlotDTO
import com.reopen.calendar.repositories.TimeSlotRepository
import com.reopen.calendar.services.TimeSlotService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/timeslots")
class TimeSlotRESTController (
    private val timeSlotService: TimeSlotService,
    private val repository: TimeSlotRepository
) {

    @GetMapping
    fun getTimeSlots(
        @RequestParam start: String,
        @RequestParam end: String
    ): ResponseEntity<List<TimeSlot>> {
        val from = LocalDateTime.parse(start)
        val to = LocalDateTime.parse(end)
        return ResponseEntity.ok(repository.findAllByTimeStartBetween(from, to))
    }

    @PostMapping("/")
    fun saveTimeSlot(
        @RequestBody dto: TimeSlotDTO
    ): ResponseEntity<TimeSlotDTO> {
        return ResponseEntity.ok(timeSlotService.saveTimeSlot(dto))
    }
}
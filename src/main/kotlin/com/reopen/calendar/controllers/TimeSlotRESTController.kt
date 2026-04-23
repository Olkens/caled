package com.reopen.calendar.controllers

import com.reopen.calendar.dto.timeslot.TimeSlotDTO
import com.reopen.calendar.services.TimeSlotService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/timeslots")
class TimeSlotRESTController (
    private val timeSlotService: TimeSlotService
) {

    @PostMapping("/")
    fun saveTimeSlot(
        @RequestBody dto: TimeSlotDTO
    ): ResponseEntity<TimeSlotDTO> {
        return ResponseEntity.ok(timeSlotService.saveTimeSlot(dto))
    }
}
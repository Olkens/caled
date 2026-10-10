package com.reopen.calendar.controllers

import com.reopen.calendar.dto.calendar.CalendarDTO
import com.reopen.calendar.repositories.CalendarRepository
import com.reopen.calendar.services.CalendarService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/calendars")
class CalendarRESTController(
    private val calendarRepository: CalendarRepository,
    private val calendarService: CalendarService
) {

    @PostMapping("/")
    fun saveCalendar(@RequestBody dto: CalendarDTO): ResponseEntity<CalendarDTO> {
        val postSaveDto = calendarService.saveCalendar(dto)
        return ResponseEntity.ok(postSaveDto)
    }
}
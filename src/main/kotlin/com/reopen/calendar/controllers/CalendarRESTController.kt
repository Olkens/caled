package com.reopen.calendar.controllers

import com.reopen.calendar.repositories.CalendarRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/calendars")
class CalendarRESTController(
    private val calendarRepository: CalendarRepository
) {

    @PostMapping
    fun saveCalendar(): ResponseEntity<> {
    }
}
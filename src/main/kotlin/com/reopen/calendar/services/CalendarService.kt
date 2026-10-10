package com.reopen.calendar.services

import com.reopen.calendar.domain.Calendar
import com.reopen.calendar.dto.calendar.CalendarDTO
import com.reopen.calendar.repositories.CalendarRepository
import org.springframework.stereotype.Service

@Service
class CalendarService (
    private val calendarRepository: CalendarRepository
) {
    fun saveCalendar(dto: CalendarDTO): CalendarDTO {
        val calendar = Calendar(
            name = dto.name,
            trainer = dto.trainer
        )
        val saved = calendarRepository.save(calendar)
        return CalendarDTO(
            id = saved.id,
            name = saved.name,
            trainer = saved.trainer,
            timeSlots = null
        )
    }
}
package com.reopen.calendar.services

import com.reopen.calendar.domain.TimeSlot
import com.reopen.calendar.dto.timeslot.TimeSlotDTO
import com.reopen.calendar.repositories.CalendarRepository
import com.reopen.calendar.repositories.TimeSlotRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class TimeSlotService(
    private val repository: TimeSlotRepository,
    private val calendarRepository: CalendarRepository
) {
    fun saveTimeSlot(dto: TimeSlotDTO): TimeSlotDTO? {
        val calendar = calendarRepository.findById(dto.calendarId)
            .orElseThrow { EntityNotFoundException("Calendar not found: ${dto.calendarId}") }
        val timeSlot = TimeSlot(
            timeStart = dto.timeStart,
            timeStop = dto.timeStop,
            calendar = calendar
        )
        val saved = repository.save(timeSlot)

        return TimeSlotDTO(
            id = saved.id,
            timeStart = saved.timeStart,
            timeStop = saved.timeStop,
            calendarId = saved.calendar.id
        )
    }
}
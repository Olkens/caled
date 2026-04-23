package com.reopen.calendar.services

import com.reopen.calendar.domain.TimeSlot
import com.reopen.calendar.dto.timeslot.TimeSlotDTO
import com.reopen.calendar.repositories.TimeSlotRepository
import org.springframework.stereotype.Service

@Service
class TimeSlotService (
    private val repository: TimeSlotRepository
) {
    fun saveTimeSlot(dto: TimeSlotDTO): TimeSlotDTO? {
        val timeSlot = TimeSlot(
            timeStart = dto.timeStart,
            timeStop = dto.timeStop
        )
        val saved = repository.save(timeSlot)

        return TimeSlotDTO(
            id = saved.id,
            timeStart = saved.timeStart,
            timeStop = saved.timeStop
        )
    }
}
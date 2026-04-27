package com.reopen.calendar.repositories

import com.reopen.calendar.domain.TimeSlot
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface TimeSlotRepository : JpaRepository<TimeSlot, Long> {
    fun findAllByTimeStartBetween(start: LocalDateTime, end: LocalDateTime): List<TimeSlot>
}
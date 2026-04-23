package com.reopen.calendar.repositories

import com.reopen.calendar.domain.TimeSlot
import org.springframework.data.jpa.repository.JpaRepository

interface TimeSlotRepository : JpaRepository<TimeSlot, Long> {
}
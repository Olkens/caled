package com.reopen.calendar.repositories

import com.reopen.calendar.domain.Calendar
import org.springframework.data.jpa.repository.JpaRepository

interface CalendarRepository : JpaRepository<Calendar, Long> {
}
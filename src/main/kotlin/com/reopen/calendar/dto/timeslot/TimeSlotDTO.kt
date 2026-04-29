package com.reopen.calendar.dto.timeslot

import com.reopen.calendar.domain.Calendar
import java.time.LocalDateTime

data class TimeSlotDTO(val id: Long?, val timeStart: LocalDateTime, val timeStop: LocalDateTime, val calendarId: Long) {

}
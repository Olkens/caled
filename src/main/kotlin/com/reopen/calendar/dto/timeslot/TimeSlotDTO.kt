package com.reopen.calendar.dto.timeslot

import java.time.LocalDateTime

data class TimeSlotDTO(val id: Long, val timeStart: LocalDateTime, val timeStop: LocalDateTime)
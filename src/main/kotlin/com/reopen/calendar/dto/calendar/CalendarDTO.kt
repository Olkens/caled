package com.reopen.calendar.dto.calendar

import com.reopen.calendar.domain.TrainerProfile

data class CalendarDTO(var id: Long?, var timeSlots: Set<Long>?, var name: String, var trainer: TrainerProfile)

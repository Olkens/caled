package com.reopen.calendar.dto.trainer

import com.reopen.calendar.dto.user.UserDataDTO

class TrainersGETResponseDTO(val id: Long, val user: UserDataDTO, val description: String, val yearsOfExperience: Int, val pricePerHour: Int)
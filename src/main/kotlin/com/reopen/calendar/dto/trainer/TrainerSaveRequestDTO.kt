package com.reopen.calendar.dto.trainer

data class TrainerSaveRequestDTO (
    val userId: Long,
    val description: String,
    val categoryIds: List<Long> = emptyList(),
    val yearsOfExperience: Int
)

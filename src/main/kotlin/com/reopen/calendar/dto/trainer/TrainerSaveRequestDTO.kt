package com.reopen.calendar.dto.trainer

data class TrainerSaveRequestDTO (
    val userId: Long,
    val categoryIds: List<Long> = emptyList(),
    val yearsOfExperience: Int)

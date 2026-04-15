package com.reopen.calendar.dto.trainer

data class TrainersGETRequestDTO(
    val categoryIds: List<Long> = emptyList(),
    val categoryNames: List<String> = emptyList()
)
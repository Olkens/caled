package com.reopen.calendar.dto.trainer

data class TrainersSaveResponseDTO(
    val id: Long,
    val userId: Long,
    val categoryIds: List<Long>,
    val description: String,
    val yearsOfExperience: Int,
    val pricePerHour: Int
) {
    override fun toString(): String {
        return "TrainersPOSTResponseDTO(id=$id, userId=$userId, categoryIds=$categoryIds, description=$description,  yearsOfExperience=$yearsOfExperience, pricePerHour=$pricePerHour)"
    }
}

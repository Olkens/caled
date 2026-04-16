package com.reopen.calendar.dto.trainer

data class TrainersPOSTResponseDTO(
    val id: Long,
    val userId: Long,
    val categoryIds: List<Long>,
    val yearsOfExperience: Int,
    val pricePerHour: Int
) {
    override fun toString(): String {
        return "TrainersPOSTResponseDTO(id=$id, userId=$userId, categoryIds=$categoryIds, yearsOfExperience=$yearsOfExperience, pricePerHour=$pricePerHour)"
    }
}

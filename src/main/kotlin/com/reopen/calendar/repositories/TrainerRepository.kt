package com.reopen.calendar.repositories

import com.reopen.calendar.domain.TrainerProfile
import com.reopen.calendar.domain.TrainingCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TrainerRepository : JpaRepository<TrainerProfile, Long> {
    fun findAllByCategories(categories: MutableList<TrainingCategory>): MutableList<TrainerProfile>
    @Query("""
        SELECT DISTINCT t FROM TrainerProfile t
        JOIN t.categories c
        WHERE c.id IN :categoryIds
    """)
    fun findByCategoryIds(
        @Param("categoryIds") categoryIds: List<Long>
    ): List<TrainerProfile>

    @Query("""
        SELECT DISTINCT t FROM TrainerProfile t
        JOIN t.categories c
        WHERE c.name IN :categoryNames
    """)
    fun findByCategoryNames(
        @Param("categoryNames") categoryNames: List<String>
    ): List<TrainerProfile>
}
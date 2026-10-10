package com.reopen.calendar.repositories

import com.reopen.calendar.domain.TrainingCategory
import org.springframework.data.jpa.repository.JpaRepository

interface TrainingCategoryRepository : JpaRepository<TrainingCategory, Long> {
}
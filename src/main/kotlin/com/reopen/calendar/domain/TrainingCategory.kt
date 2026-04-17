package com.reopen.calendar.domain

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "training_categories")
class TrainingCategory(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToMany(mappedBy = "categories")
    var trainers: MutableSet<TrainerProfile> = mutableSetOf(),

    var name: String,
    var description: String,

    ) {
}
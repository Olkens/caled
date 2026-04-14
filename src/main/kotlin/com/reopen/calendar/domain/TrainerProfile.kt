package com.reopen.calendar.domain

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "trainer_profiles")
class TrainerProfile(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "trainer_categories",
        joinColumns = [JoinColumn(name = "trainer_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    val categories: MutableList<TrainingCategory> = mutableListOf(),

    val yearsOfExperience: Int = 0,
    val pricePerHour: Int = 0,

) {
}
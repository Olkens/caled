package com.reopen.calendar.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne

@Entity
class Calendar(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column("name", nullable = false)
    var name: String,

    @OneToOne
    @JoinColumn(name = "trainer_id")
    var trainer: TrainerProfile,

    @OneToMany(mappedBy = "calendar", cascade = [CascadeType.ALL], orphanRemoval = true)
    var timeSlots: MutableSet<TimeSlot> = mutableSetOf()

) {

}
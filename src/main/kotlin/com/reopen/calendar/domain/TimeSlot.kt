package com.reopen.calendar.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "time_slot")
@EntityListeners(AuditingEntityListener::class)
class TimeSlot(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "time_start", nullable = false)
    var timeStart: LocalDateTime,

    @Column(name = "time_stop", nullable = false)
    var timeStop: LocalDateTime,

    @CreatedDate
    @Column(name = "date_created", nullable = false, updatable = false)
    var dateCreated: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate
    @Column(name = "date_updated", nullable = false)
    var dateUpdated: LocalDateTime = LocalDateTime.now(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "calendar_id", nullable = false)
    var calendar: Calendar
)
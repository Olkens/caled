package com.reopen.calendar.repositories

import com.reopen.calendar.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
    fun existsByUsernameAndIdNot(username: String, id: Long): Boolean
    // Email jest value class -> na poziomie JVM kolumna to String
    fun existsByEmailAndIdNot(email: String, id: Long): Boolean
}
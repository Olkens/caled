package com.reopen.calendar.services

import com.reopen.calendar.domain.Role
import com.reopen.calendar.dto.user.UserUpdateRequestDTO
import com.reopen.calendar.dto.user.UserUpdateResponseDTO
import com.reopen.calendar.repositories.UserRepository
import com.reopen.calendar.types.Email
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(
    private val userRepository: UserRepository
) {
    @Transactional
    fun updateUser(id: Long, dto: UserUpdateRequestDTO): UserUpdateResponseDTO {
        val user = userRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: $id") }

        val username = dto.username.trim()
        if (username.isBlank()) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Username cannot be blank")
        }

        val email = try {
            Email(dto.email.trim())
        } catch (e: IllegalArgumentException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message)
        }

        val role = Role.entries.find { it.name == dto.role.uppercase() }
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid role: ${dto.role}")

        if (userRepository.existsByUsernameAndIdNot(username, id)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Username already taken: $username")
        }
        if (userRepository.existsByEmailAndIdNot(email.value, id)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Email already taken: ${email.value}")
        }

        user.changeUsername(username)
        user.email = email
        user.role = role

        val saved = userRepository.save(user)

        return UserUpdateResponseDTO(
            id = saved.id,
            username = saved.username,
            email = saved.email.value,
            name = saved.name,
            role = saved.role.name
        )
    }
}

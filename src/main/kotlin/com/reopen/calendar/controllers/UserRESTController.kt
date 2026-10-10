package com.reopen.calendar.controllers

import com.reopen.calendar.dto.user.UserUpdateRequestDTO
import com.reopen.calendar.dto.user.UserUpdateResponseDTO
import com.reopen.calendar.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserRESTController(
    private val userService: UserService
) {
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    fun updateUser(
        @PathVariable id: Long,
        @RequestBody dto: UserUpdateRequestDTO
    ): ResponseEntity<UserUpdateResponseDTO> {
        return ResponseEntity.ok(userService.updateUser(id, dto))
    }
}

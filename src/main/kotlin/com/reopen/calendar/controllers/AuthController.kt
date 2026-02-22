package com.reopen.calendar.controllers

import com.reopen.calendar.dto.auth.AuthResponse
import com.reopen.calendar.dto.auth.LoginRequest
import com.reopen.calendar.dto.auth.RegisterRequest
import com.reopen.calendar.services.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<AuthResponse> =
        ResponseEntity.ok(authService.register(request))

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<AuthResponse> =
        ResponseEntity.ok(authService.login(request))
}
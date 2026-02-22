package com.reopen.calendar.services

import com.reopen.calendar.dto.auth.AuthResponse
import com.reopen.calendar.dto.auth.LoginRequest
import com.reopen.calendar.dto.auth.RegisterRequest
import com.reopen.calendar.security.JwtService
import com.reopen.calendar.domain.Role
import com.reopen.calendar.domain.User
import com.reopen.calendar.repositories.UserRepository
import com.reopen.calendar.types.Email
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) {

    fun register(request: RegisterRequest): AuthResponse {
        val user = User(
            username = request.username,
            password = passwordEncoder.encode(request.password),
            role = Role.valueOf(request.role.uppercase()),
            email = Email(request.email)
        )
        userRepository.save(user)
        return AuthResponse(token = jwtService.generateToken(user))
    }

    fun login(request: LoginRequest): AuthResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(request.username, request.password)
        )
        val user = userRepository.findByUsername(request.username)!!
        return AuthResponse(token = jwtService.generateToken(user))
    }
}
package com.reopen.calendar.dto.auth

data class RegisterRequest(val username: String, val password: String, val role: String = "USER", val email: String)
package com.reopen.calendar.domain

import com.reopen.calendar.types.Email
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "users")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(unique = true)
    private var username: String,

    @Column(unique = true) var email: Email,

    private var password: String?,

    @Enumerated(EnumType.STRING)
    var role: Role = Role.USER

) : UserDetails {
    override fun getUsername() = username
    override fun getPassword() = password
    override fun getAuthorities(): Collection<GrantedAuthority> =
        listOf(SimpleGrantedAuthority("ROLE_${role.name}"))
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true
}

enum class Role { USER, ADMIN }
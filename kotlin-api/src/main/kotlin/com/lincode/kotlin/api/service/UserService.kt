package com.lincode.kotlin.api.service

import com.lincode.kotlin.api.entity.User
import com.lincode.kotlin.api.repository.UserRepository
import org.springframework.stereotype.Component

@Component
open class UserService constructor(override val entityRepository: UserRepository) : EntityService<User, Long>(entityRepository) {

    override fun findAll() = entityRepository.findByOrderByIdDesc()

    fun login(email: String, password: String) : User {
        return entityRepository.findFirstByEmailAndPassword(email, password)
    }

}
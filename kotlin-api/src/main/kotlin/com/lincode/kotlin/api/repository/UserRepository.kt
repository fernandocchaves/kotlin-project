package com.lincode.kotlin.api.repository

import com.lincode.kotlin.api.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, Long> {

    fun findFirstByEmailAndPassword(email: String, password: String) : User
    fun findByOrderByIdDesc() : Iterable<User>

}
package com.lincode.kotlin.api.controller

import com.lincode.kotlin.api.entity.User
import com.lincode.kotlin.api.service.UserService
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/")
class LoginController {

    @Autowired
    lateinit var userService : UserService

    @PostMapping("/login", produces = arrayOf("application/json"))
    fun login(@RequestBody request: User) : User {
        val user : User = userService.login(request.email, request.password)
        return user
    }
}
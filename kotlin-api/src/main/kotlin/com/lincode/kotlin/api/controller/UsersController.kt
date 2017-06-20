package com.lincode.kotlin.api.controller

import com.lincode.kotlin.api.entity.User
import com.lincode.kotlin.api.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UsersController(var userService : UserService) {

    @GetMapping("/")
    fun list() = userService.findAll()

    @GetMapping("/{id}")
    fun show(id: Long) = userService.find(id)

    @PostMapping("/")
    fun create(@RequestBody request: User) = userService.save(request)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: User) : User {
        val entity = userService.validateRecord(id)
        if(!entity.isPresent){
            throw IllegalStateException("Registro não encontrado")
        }

        return userService.save(request)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : String {
        val entity = userService.validateRecord(id)
        if(!entity.isPresent){
            throw IllegalStateException("Registro não encontrado")
        }

        userService.delete(entity.get())
        return "Excluido"
    }

}
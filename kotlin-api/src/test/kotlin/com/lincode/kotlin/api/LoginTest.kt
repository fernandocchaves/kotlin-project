package com.lincode.kotlin.api

import com.lincode.kotlin.api.controller.LoginController
import com.lincode.kotlin.api.controller.UsersController
import com.lincode.kotlin.api.entity.User
import com.lincode.kotlin.api.service.UserService
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@RunWith(SpringRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@AutoConfigureRestDocs(outputDir = "target/snippets")
@WebMvcTest(controllers = arrayOf(LoginController::class, UsersController::class))

class LoginTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    private val userService: UserService? = null

    @Test
    fun createUser() {
        val user = "{\"name\": \"Fernando Chaves\", \"email\": \"fernandocchaves@gmail.com\", \"password\": \"12345\"}"

        this.post("/api/v1/users/", user)
            .andExpect(status().is4xxClientError)
            //.andDo(document("users/create"))
    }

    @Test
    fun login() {
        val login = "{\"email\": \"fernandocchaves@gmail.com\",\"password\": \"12345\"}"

        this.post("/api/v1/login", login)
            .andExpect(status().is4xxClientError)
            //.andDo(document("login"))
    }

    @Throws(Exception::class)
    fun get(endpoint: String): ResultActions {
        return mockMvc.perform(MockMvcRequestBuilders.post(endpoint)
                .accept(MediaType.APPLICATION_JSON))
    }

    @Throws(Exception::class)
    fun post(endpoint: String, content: String): ResultActions {
        return mockMvc.perform(MockMvcRequestBuilders.post(endpoint)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
    }
}

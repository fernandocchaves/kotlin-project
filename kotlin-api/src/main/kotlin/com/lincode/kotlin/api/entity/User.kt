package com.lincode.kotlin.api.entity

import io.swagger.annotations.ApiModelProperty
import javax.persistence.*


@Entity(name="user")
data class User(
        var name : String = "",
        var email : String = "",
        @ApiModelProperty(hidden = true)
        var password : String = "",
        @ApiModelProperty(hidden = true)
        var active : Boolean = true,
        @ApiModelProperty(hidden = true)
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id : Long = 0
)
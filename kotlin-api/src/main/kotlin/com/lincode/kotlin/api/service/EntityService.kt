package com.lincode.kotlin.api.service

import org.springframework.data.repository.CrudRepository
import java.io.Serializable
import java.util.*

open class EntityService<T, ID : Serializable>(open val entityRepository : CrudRepository<T, ID>) {

    fun find(id: ID) = entityRepository.findOne(id)

    open fun findAll() = entityRepository.findAll()

    fun save(entity: T) : T {
        entityRepository.save(entity)
        return entity
    }

    fun delete(entity: T){
        entityRepository.delete(entity)
    }

    fun validateRecord(id: ID) = Optional.ofNullable(find(id))

}
package com.github.thorlauridsen.persistence

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Customer repository interface.
 * This is a JPA repository for the customer entity.
 * It extends the [JpaRepository] interface which allows us to easily define CRUD methods.
 */
interface CustomerRepo : JpaRepository<CustomerEntity, UUID>

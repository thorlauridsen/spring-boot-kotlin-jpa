package com.github.thorlauridsen.persistence

import com.github.thorlauridsen.model.Customer
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

/**
 * Customer entity class.
 * Represents a customer with an id and an email.
 */
@Entity
@Table(name = "customer")
class CustomerEntity(

    @Id
    @GeneratedValue
    val id: UUID? = null,

    @Column(nullable = false)
    val mail: String? = null,
) {

    /**
     * Empty default constructor required by JPA.
     */
    constructor() : this(null, null)

    /**
     * Convert this entity to a [Customer].
     * @throws IllegalStateException if id is null.
     * @return [Customer]
     */
    fun toModel(): Customer {
        return Customer(
            id = id ?: error("Customer id is null for mail: $mail"),
            mail = mail ?: error("Customer mail is null for id: $id")
        )
    }
}

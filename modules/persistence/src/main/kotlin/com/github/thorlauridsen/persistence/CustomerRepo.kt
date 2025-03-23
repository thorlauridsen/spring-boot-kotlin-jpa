package com.github.thorlauridsen.persistence

import com.github.thorlauridsen.model.Customer
import com.github.thorlauridsen.model.CustomerInput
import java.util.UUID
import kotlin.jvm.optionals.getOrNull
import org.springframework.stereotype.Repository

/**
 * Customer repository facade class.
 *
 * This class is a facade for the [CustomerJpaRepo].
 * A service class can use this facade to easily interact with the
 * repository without needing to know about the database entity [CustomerEntity].
 *
 * It is annotated with [Repository] to allow Spring to automatically
 * detect it as a bean and inject it where needed.
 *
 * @param customerRepo [CustomerJpaRepo] to interact with the database.
 */
@Repository
class CustomerRepo(private val customerRepo: CustomerJpaRepo) : ICustomerRepo {

    /**
     * Save a customer.
     * @param customer [CustomerInput] to save.
     * @return [Customer] retrieved from database.
     */
    override fun save(customer: CustomerInput): Customer {
        val entity = CustomerEntity(
            mail = customer.mail,
        )
        val created = customerRepo.save(entity)
        return created.toModel()
    }

    /**
     * Get a customer given an id.
     * @param id [UUID] to fetch customer.
     * @return [Customer] or null if not found.
     */
    override fun find(id: UUID): Customer? {
        val entity = customerRepo.findById(id).getOrNull()
        return entity?.toModel()
    }
}

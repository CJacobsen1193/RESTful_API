package edu.franklin;

import java.util.List;
import java.util.Random;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
public class CustomerEntity extends PanacheEntity {
    
    @NotBlank(message="name cannot be blank")
    public String name;

    @NotBlank(message = "email cannot be blank")
    public String email;

    public float balance;

    /*
     * Persists a customer, adding them to the database
     */
    public static void persistCustomer(CustomerEntity customer) {
        customer.persist();
    }

    /*
     * Takes the customer's ID as parameters and queries
     * the database to get the customer
     */
    public static CustomerEntity findCustomerById(Long id) {
        if (find("id", id).firstResult() == null) {
            return null;
        }

        return find("id", id).firstResult();
    }

    /*
     * Takes the customer's name as parameters and queries
     * the database to get the customer
     */
    public static CustomerEntity findCustomerByName(String name) {
        if (find("name", name).firstResult() == null) {
            return null;
        }

        return find("name", name).firstResult();
    }

    /*
     * Queries the database to provide a list of all customers
     */
    public static List<CustomerEntity> findAllCustomers() {
        if (CustomerEntity.listAll() == null) {
            return null;
        }

        return listAll();
    }

    /*
     * Assigns a "list" field with all customers from the
     * database. Uses a Random object to generate an index
     * to get a customer with.
     */
    public static CustomerEntity findRandomCustomer() {
        if (CustomerEntity.listAll() == null) {
            return null;
        }

        Random random = new Random();
        List<CustomerEntity> list = CustomerEntity.listAll();
        return (CustomerEntity) list.get(random.nextInt(list.size()));
    }

    /*
     * Takes a validated customer and attaches it to 
     * and "updatedCustomer" field. Changes made to the customer
     * data persists. 
     */
    public static CustomerEntity updateCustomer(CustomerEntity customer, Long id) {
        if (CustomerEntity.findCustomerById(id) == null) {
            return null;
        }
        CustomerEntity updatedCustomer = CustomerEntity.findCustomerById(id);
        updatedCustomer.name = customer.name;
        updatedCustomer.email = customer.email;
        updatedCustomer.balance = customer.balance;
        
        return CustomerEntity.findCustomerById(id);
    }

    /*
     * Takes a customer ID and removes the customer 
     * from the database
     */
    public static void deleteCustomer(Long id) {
        CustomerEntity.delete("id", id);
    }
}
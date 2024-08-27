package edu.franklin;

import java.net.URI;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Path("/customer")
@Tag(name = "Customer Resource", description = "Customer CRUD")
public class CustomerEntityResource {
    

    public CustomerEntityResource() {

    }

    /*
     * Calls findCustomerById() to get a single customer from the database
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Tag(name = "Get Customer by ID", description = "calls findCustomerById()")
    public Response getCustomerById(@Valid Long id) {
        if (CustomerEntity.findCustomerById(id) == null) {
            return Response.noContent().build();
        }
        return Response.ok(CustomerEntity.findCustomerById(id)).build();
    }

    /*
     * Calls findAllCustomers() to get a list of all 
     * customers in the database.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Tag(name = "Get All Customers", description = "calls findAllCustomers()")
    public Response getAllCustomers() {
        if (CustomerEntity.findAllCustomers() == null) {
            return Response.noContent().build();
        }
        return Response.ok(CustomerEntity.findAllCustomers()).build();
    }

    /*
     * Calls findRandomCustomer() to return a single customer
     * from the database at random.
     */
    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    @Tag(name = "Get Random Customer", description = "calls findRandomCustomer()")
    public Response getRandomCustomer() {
        if (CustomerEntity.findAllCustomers() == null) {
            return Response.noContent().build();
        }
        return Response.ok(CustomerEntity.findRandomCustomer()).build();
    }

    @POST 
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Tag(name = "Create Customer", description = "calls persistCustomer()")
    public Response createCustomer(@Valid CustomerEntity customer) {
        CustomerEntity.persistCustomer(customer);
        return Response.created(URI.create("/customer/" + customer.id)).build();
    }
    
    @PUT
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Tag(name = "Update Customer", description = "calls updateCustomer()")
    public Response updateCustomer(@Valid CustomerEntity customer, @Valid Long id) {
        if (CustomerEntity.findCustomerById(id) == null) {
            return Response.noContent().build();
        }
        return Response.ok(CustomerEntity.updateCustomer(customer, id)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Tag(name = "Delete Customer", description = "calls deleteCustomer()")
    public Response deleteCustomer(@Valid Long id) {
        CustomerEntity.deleteCustomer(id);
        return Response.noContent().build();
    }
}
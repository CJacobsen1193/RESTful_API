package edu.franklin;

import java.time.Instant;
import java.util.UUID;

import org.eclipse.microprofile.reactive.messaging.*;

import io.quarkus.grpc.GrpcClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/purchase")
public class PurchaseResource {

    @Inject
    @GrpcClient("customer")
    CustomerServiceGrpc.CustomerServiceBlockingStub customerService;

    @Inject
    @GrpcClient("product")
    ProductServiceGrpc.ProductServiceBlockingStub productService;

    @Inject
    @Channel("reports-out")
    Emitter<Report> reportEmitter;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPurchase() {
        try {
            int customerAttempts = 0;
            while (customerAttempts < 3) {
                Customer customer = customerService.getRandomCustomer(GetRandomCustomerRequest.newBuilder().build());

                int productAttempts = 0;
                while (productAttempts < 3) {
                    Product product = productService.randomProduct(GetRandomProductRequest.newBuilder().build());
                    if (customer.getBalance() >= product.getPrice()) {
                        Report report = new Report(UUID.randomUUID(), customer.getId(), product.getId(),
                                Instant.now(), product.getPrice());
                        reportEmitter.send(report);
                        return Response.status(Response.Status.CREATED).entity("Purchase processed successfully")
                                .build();
                    }
                    productAttempts++;
                }
                customerAttempts++;
            }

            return Response.status(Response.Status.BAD_REQUEST).entity("Insufficient balance for 3 random customers")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error processing purchase").build();
        }
    }
}

package edu.franklin;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: customer.proto")
public interface CustomerService extends MutinyService {

    io.smallrye.mutiny.Uni<edu.franklin.Customer> getRandomCustomer(edu.franklin.GetRandomCustomerRequest request);

    io.smallrye.mutiny.Uni<edu.franklin.UpdateCustomerResponse> updateCustomer(edu.franklin.Customer request);
}

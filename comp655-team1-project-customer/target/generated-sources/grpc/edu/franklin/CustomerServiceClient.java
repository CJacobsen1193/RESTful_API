package edu.franklin;

import java.util.function.BiFunction;
import io.quarkus.grpc.MutinyClient;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: customer.proto")
public class CustomerServiceClient implements CustomerService, MutinyClient<MutinyCustomerServiceGrpc.MutinyCustomerServiceStub> {

    private final MutinyCustomerServiceGrpc.MutinyCustomerServiceStub stub;

    public CustomerServiceClient(String name, io.grpc.Channel channel, BiFunction<String, MutinyCustomerServiceGrpc.MutinyCustomerServiceStub, MutinyCustomerServiceGrpc.MutinyCustomerServiceStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinyCustomerServiceGrpc.newMutinyStub(channel));
    }

    private CustomerServiceClient(MutinyCustomerServiceGrpc.MutinyCustomerServiceStub stub) {
        this.stub = stub;
    }

    public CustomerServiceClient newInstanceWithStub(MutinyCustomerServiceGrpc.MutinyCustomerServiceStub stub) {
        return new CustomerServiceClient(stub);
    }

    @Override
    public MutinyCustomerServiceGrpc.MutinyCustomerServiceStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<edu.franklin.Customer> getRandomCustomer(edu.franklin.GetRandomCustomerRequest request) {
        return stub.getRandomCustomer(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<edu.franklin.UpdateCustomerResponse> updateCustomer(edu.franklin.Customer request) {
        return stub.updateCustomer(request);
    }
}

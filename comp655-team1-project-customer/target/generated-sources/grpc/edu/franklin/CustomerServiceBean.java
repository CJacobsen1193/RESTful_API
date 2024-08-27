package edu.franklin;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: customer.proto")
public class CustomerServiceBean extends MutinyCustomerServiceGrpc.CustomerServiceImplBase implements BindableService, MutinyBean {

    private final CustomerService delegate;

    CustomerServiceBean(@GrpcService CustomerService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<edu.franklin.Customer> getRandomCustomer(edu.franklin.GetRandomCustomerRequest request) {
        try {
            return delegate.getRandomCustomer(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<edu.franklin.UpdateCustomerResponse> updateCustomer(edu.franklin.Customer request) {
        try {
            return delegate.updateCustomer(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}

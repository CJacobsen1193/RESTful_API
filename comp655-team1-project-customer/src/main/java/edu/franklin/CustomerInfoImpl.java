package edu.franklin;

import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

@GrpcService
public class CustomerInfoImpl extends CustomerServiceGrpc.CustomerServiceImplBase {
    
    @Override
    public void getRandomCustomer(GetRandomCustomerRequest request, StreamObserver<Customer> responseObserver) {
        if (CustomerEntity.findAllCustomers() == null) {
            responseObserver.onError(io.grpc.Status.NOT_FOUND.withDescription
            ("No customers found").asRuntimeException());
        }
        CustomerEntity customer = CustomerEntity.findRandomCustomer();

        responseObserver.onNext(Customer.newBuilder()
        .setName(customer.name)
        .setEmail(customer.email)
        .setBalance(customer.balance).build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateCustomer(Customer request, StreamObserver<UpdateCustomerResponse> responseObserver) {
        if (CustomerEntity.findCustomerById(request.getId()) == null) {
            responseObserver.onError(io.grpc.Status.NOT_FOUND.withDescription
            ("Customer not found").asRuntimeException());
        }

        CustomerEntity customer = CustomerEntity.findCustomerById(request.getId());
        customer.balance -= request.getPrice();
        responseObserver.onNext(UpdateCustomerResponse.newBuilder().setSuccess(true).build());
        responseObserver.onCompleted();
    }
} 

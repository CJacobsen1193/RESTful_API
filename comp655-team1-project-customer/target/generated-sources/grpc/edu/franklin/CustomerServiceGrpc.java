package edu.franklin;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.quarkus.Generated(value = "by gRPC proto compiler (version 1.57.2)", comments = "Source: customer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CustomerServiceGrpc {

    private CustomerServiceGrpc() {
    }

    public static final java.lang.String SERVICE_NAME = "customer.CustomerService";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<edu.franklin.GetRandomCustomerRequest, edu.franklin.Customer> getGetRandomCustomerMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "GetRandomCustomer", requestType = edu.franklin.GetRandomCustomerRequest.class, responseType = edu.franklin.Customer.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<edu.franklin.GetRandomCustomerRequest, edu.franklin.Customer> getGetRandomCustomerMethod() {
        io.grpc.MethodDescriptor<edu.franklin.GetRandomCustomerRequest, edu.franklin.Customer> getGetRandomCustomerMethod;
        if ((getGetRandomCustomerMethod = CustomerServiceGrpc.getGetRandomCustomerMethod) == null) {
            synchronized (CustomerServiceGrpc.class) {
                if ((getGetRandomCustomerMethod = CustomerServiceGrpc.getGetRandomCustomerMethod) == null) {
                    CustomerServiceGrpc.getGetRandomCustomerMethod = getGetRandomCustomerMethod = io.grpc.MethodDescriptor.<edu.franklin.GetRandomCustomerRequest, edu.franklin.Customer>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRandomCustomer")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(edu.franklin.GetRandomCustomerRequest.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(edu.franklin.Customer.getDefaultInstance())).setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("GetRandomCustomer")).build();
                }
            }
        }
        return getGetRandomCustomerMethod;
    }

    private static volatile io.grpc.MethodDescriptor<edu.franklin.Customer, edu.franklin.UpdateCustomerResponse> getUpdateCustomerMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "UpdateCustomer", requestType = edu.franklin.Customer.class, responseType = edu.franklin.UpdateCustomerResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<edu.franklin.Customer, edu.franklin.UpdateCustomerResponse> getUpdateCustomerMethod() {
        io.grpc.MethodDescriptor<edu.franklin.Customer, edu.franklin.UpdateCustomerResponse> getUpdateCustomerMethod;
        if ((getUpdateCustomerMethod = CustomerServiceGrpc.getUpdateCustomerMethod) == null) {
            synchronized (CustomerServiceGrpc.class) {
                if ((getUpdateCustomerMethod = CustomerServiceGrpc.getUpdateCustomerMethod) == null) {
                    CustomerServiceGrpc.getUpdateCustomerMethod = getUpdateCustomerMethod = io.grpc.MethodDescriptor.<edu.franklin.Customer, edu.franklin.UpdateCustomerResponse>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCustomer")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(edu.franklin.Customer.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(edu.franklin.UpdateCustomerResponse.getDefaultInstance())).setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("UpdateCustomer")).build();
                }
            }
        }
        return getUpdateCustomerMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static CustomerServiceStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<CustomerServiceStub> factory = new io.grpc.stub.AbstractStub.StubFactory<CustomerServiceStub>() {

            @java.lang.Override
            public CustomerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new CustomerServiceStub(channel, callOptions);
            }
        };
        return CustomerServiceStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static CustomerServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<CustomerServiceBlockingStub> factory = new io.grpc.stub.AbstractStub.StubFactory<CustomerServiceBlockingStub>() {

            @java.lang.Override
            public CustomerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new CustomerServiceBlockingStub(channel, callOptions);
            }
        };
        return CustomerServiceBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static CustomerServiceFutureStub newFutureStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<CustomerServiceFutureStub> factory = new io.grpc.stub.AbstractStub.StubFactory<CustomerServiceFutureStub>() {

            @java.lang.Override
            public CustomerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new CustomerServiceFutureStub(channel, callOptions);
            }
        };
        return CustomerServiceFutureStub.newStub(factory, channel);
    }

    /**
     */
    public interface AsyncService {

        /**
         */
        default void getRandomCustomer(edu.franklin.GetRandomCustomerRequest request, io.grpc.stub.StreamObserver<edu.franklin.Customer> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRandomCustomerMethod(), responseObserver);
        }

        /**
         */
        default void updateCustomer(edu.franklin.Customer request, io.grpc.stub.StreamObserver<edu.franklin.UpdateCustomerResponse> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCustomerMethod(), responseObserver);
        }
    }

    /**
     * Base class for the server implementation of the service CustomerService.
     */
    public static abstract class CustomerServiceImplBase implements io.grpc.BindableService, AsyncService {

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return CustomerServiceGrpc.bindService(this);
        }
    }

    /**
     * A stub to allow clients to do asynchronous rpc calls to service CustomerService.
     */
    public static class CustomerServiceStub extends io.grpc.stub.AbstractAsyncStub<CustomerServiceStub> {

        private CustomerServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CustomerServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CustomerServiceStub(channel, callOptions);
        }

        /**
         */
        public void getRandomCustomer(edu.franklin.GetRandomCustomerRequest request, io.grpc.stub.StreamObserver<edu.franklin.Customer> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getGetRandomCustomerMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void updateCustomer(edu.franklin.Customer request, io.grpc.stub.StreamObserver<edu.franklin.UpdateCustomerResponse> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getUpdateCustomerMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     * A stub to allow clients to do synchronous rpc calls to service CustomerService.
     */
    public static class CustomerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CustomerServiceBlockingStub> {

        private CustomerServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CustomerServiceBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CustomerServiceBlockingStub(channel, callOptions);
        }

        /**
         */
        public edu.franklin.Customer getRandomCustomer(edu.franklin.GetRandomCustomerRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getGetRandomCustomerMethod(), getCallOptions(), request);
        }

        /**
         */
        public edu.franklin.UpdateCustomerResponse updateCustomer(edu.franklin.Customer request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getUpdateCustomerMethod(), getCallOptions(), request);
        }
    }

    /**
     * A stub to allow clients to do ListenableFuture-style rpc calls to service CustomerService.
     */
    public static class CustomerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CustomerServiceFutureStub> {

        private CustomerServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CustomerServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CustomerServiceFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<edu.franklin.Customer> getRandomCustomer(edu.franklin.GetRandomCustomerRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getGetRandomCustomerMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<edu.franklin.UpdateCustomerResponse> updateCustomer(edu.franklin.Customer request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getUpdateCustomerMethod(), getCallOptions()), request);
        }
    }

    private static final int METHODID_GET_RANDOM_CUSTOMER = 0;

    private static final int METHODID_UPDATE_CUSTOMER = 1;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>, io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final AsyncService serviceImpl;

        private final int methodId;

        MethodHandlers(AsyncService serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                case METHODID_GET_RANDOM_CUSTOMER:
                    serviceImpl.getRandomCustomer((edu.franklin.GetRandomCustomerRequest) request, (io.grpc.stub.StreamObserver<edu.franklin.Customer>) responseObserver);
                    break;
                case METHODID_UPDATE_CUSTOMER:
                    serviceImpl.updateCustomer((edu.franklin.Customer) request, (io.grpc.stub.StreamObserver<edu.franklin.UpdateCustomerResponse>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    public static io.grpc.ServerServiceDefinition bindService(AsyncService service) {
        return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(getGetRandomCustomerMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<edu.franklin.GetRandomCustomerRequest, edu.franklin.Customer>(service, METHODID_GET_RANDOM_CUSTOMER))).addMethod(getUpdateCustomerMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<edu.franklin.Customer, edu.franklin.UpdateCustomerResponse>(service, METHODID_UPDATE_CUSTOMER))).build();
    }

    private static abstract class CustomerServiceBaseDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {

        CustomerServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return edu.franklin.CustomerOuterClass.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("CustomerService");
        }
    }

    private static final class CustomerServiceFileDescriptorSupplier extends CustomerServiceBaseDescriptorSupplier {

        CustomerServiceFileDescriptorSupplier() {
        }
    }

    private static final class CustomerServiceMethodDescriptorSupplier extends CustomerServiceBaseDescriptorSupplier implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {

        private final java.lang.String methodName;

        CustomerServiceMethodDescriptorSupplier(java.lang.String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (CustomerServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new CustomerServiceFileDescriptorSupplier()).addMethod(getGetRandomCustomerMethod()).addMethod(getUpdateCustomerMethod()).build();
                }
            }
        }
        return result;
    }
}

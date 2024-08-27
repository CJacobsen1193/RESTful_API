package edu.franklin;

import static edu.franklin.CustomerServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: customer.proto")
public final class MutinyCustomerServiceGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyCustomerServiceGrpc() {
    }

    public static MutinyCustomerServiceStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyCustomerServiceStub(channel);
    }

    public static class MutinyCustomerServiceStub extends io.grpc.stub.AbstractStub<MutinyCustomerServiceStub> implements io.quarkus.grpc.MutinyStub {

        private CustomerServiceGrpc.CustomerServiceStub delegateStub;

        private MutinyCustomerServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = CustomerServiceGrpc.newStub(channel);
        }

        private MutinyCustomerServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = CustomerServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyCustomerServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyCustomerServiceStub(channel, callOptions);
        }

        public io.smallrye.mutiny.Uni<edu.franklin.Customer> getRandomCustomer(edu.franklin.GetRandomCustomerRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::getRandomCustomer);
        }

        public io.smallrye.mutiny.Uni<edu.franklin.UpdateCustomerResponse> updateCustomer(edu.franklin.Customer request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::updateCustomer);
        }
    }

    public static abstract class CustomerServiceImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public CustomerServiceImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        public io.smallrye.mutiny.Uni<edu.franklin.Customer> getRandomCustomer(edu.franklin.GetRandomCustomerRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<edu.franklin.UpdateCustomerResponse> updateCustomer(edu.franklin.Customer request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(edu.franklin.CustomerServiceGrpc.getGetRandomCustomerMethod(), asyncUnaryCall(new MethodHandlers<edu.franklin.GetRandomCustomerRequest, edu.franklin.Customer>(this, METHODID_GET_RANDOM_CUSTOMER, compression))).addMethod(edu.franklin.CustomerServiceGrpc.getUpdateCustomerMethod(), asyncUnaryCall(new MethodHandlers<edu.franklin.Customer, edu.franklin.UpdateCustomerResponse>(this, METHODID_UPDATE_CUSTOMER, compression))).build();
        }
    }

    private static final int METHODID_GET_RANDOM_CUSTOMER = 0;

    private static final int METHODID_UPDATE_CUSTOMER = 1;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>, io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final CustomerServiceImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(CustomerServiceImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                case METHODID_GET_RANDOM_CUSTOMER:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((edu.franklin.GetRandomCustomerRequest) request, (io.grpc.stub.StreamObserver<edu.franklin.Customer>) responseObserver, compression, serviceImpl::getRandomCustomer);
                    break;
                case METHODID_UPDATE_CUSTOMER:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((edu.franklin.Customer) request, (io.grpc.stub.StreamObserver<edu.franklin.UpdateCustomerResponse>) responseObserver, compression, serviceImpl::updateCustomer);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }
}

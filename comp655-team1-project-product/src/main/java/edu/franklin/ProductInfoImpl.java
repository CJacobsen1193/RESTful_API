package edu.franklin;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;

@GrpcService
public class ProductInfoImpl extends ProductServiceGrpc.ProductServiceImplBase {

	@Override
	public void randomProduct(GetRandomProductRequest request, StreamObserver<Product> responseObserver) {
		ProductEntity pro = ProductEntity.findRandomProduct();
		if (pro == null) {
			responseObserver.onError(Status.NOT_FOUND.withDescription("Product not found").asRuntimeException());
			return;
		}

		responseObserver
				.onNext(Product.newBuilder().setName(pro.name).setPrice(pro.price).setQuantity(pro.quantity).build());
		responseObserver.onCompleted();
	}

	@Override
	public void updateProduct(Product request, StreamObserver<UpdateProductResponse> responseObserver) {
		ProductEntity pro = ProductEntity.findById(request.getId());
		if (pro == null) {
			responseObserver.onError(Status.NOT_FOUND.withDescription("This product does not exist in the database")
					.asRuntimeException());
			return;
		}

		pro.setQuantity((int) (request.getQuantity()));
		pro.persist();

		responseObserver.onNext(UpdateProductResponse.newBuilder().setSuccess(true).build());
		responseObserver.onCompleted();
	}
}

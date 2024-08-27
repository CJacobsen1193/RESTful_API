package edu.franklin;

import java.util.UUID;

import org.eclipse.microprofile.reactive.messaging.*;

import io.quarkus.grpc.GrpcClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PurchaseProcessor {

    @Inject
    @GrpcClient("customer")
    CustomerServiceGrpc.CustomerServiceBlockingStub customerService;

    @Inject
    @GrpcClient("product")
    ProductServiceGrpc.ProductServiceBlockingStub productService;

    @Channel("reports-out")
    Emitter<Report> reportEmitter;

    @Incoming("orders-in")
    public void receiveOrderConfirmation(UUID orderId) {
        Purchase.<Purchase>findById(orderId).subscribe().with(purchase -> {
            if (purchase != null) {
                Customer currentCustomer = customerService
                        .getRandomCustomer(GetRandomCustomerRequest.newBuilder().setId(purchase.customer_id).build());
                Product currentProduct = productService
                        .randomProduct(GetRandomProductRequest.newBuilder().setId(purchase.product_id).build());

                Customer updatedCustomer = Customer.newBuilder()
                        .setId(currentCustomer.getId())
                        .setBalance(currentCustomer.getBalance() - purchase.amount)
                        .build();
                customerService.updateCustomer(updatedCustomer);

                Product updatedProduct = Product.newBuilder()
                        .setId(currentProduct.getId())
                        .setQuantity(currentProduct.getQuantity() - 1)
                        .build();
                productService.updateProduct(updatedProduct);
            }
        }, failure -> {
            failure.printStackTrace();
        });
    }

    // @Outgoing("reports-out")
    // public Uni<Report> processPurchase(Purchase purchase) {
    // return Uni.createFrom().item(() -> {
    // Report report = new Report(
    // purchase.order_id,
    // purchase.customer_id,
    // purchase.product_id,
    // Instant.now(),
    // purchase.amount);

    // reportEmitter.send(report);
    // return report;
    // });
    // }
}

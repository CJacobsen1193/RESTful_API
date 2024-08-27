package edu.franklin;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@RegisterForReflection
public class ProductEntity extends PanacheEntity{
	
	@NotBlank(message = "name cannot be blank")
	public String name;
	
	@NotNull
	public int quantity;
	
	@NotNull
	public float price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public static Object findAllProducts() {
		return listAll();
	}

	public static void persistProduct(ProductEntity product) {
		product.persist();
	}

	public static ProductEntity getProductById(Long id) {
		return findById(id);
	}

	public static ProductEntity findRandomProduct() {
		return find("order by random()").firstResult();
	}

	public static ProductEntity updateProduct(Long id, ProductEntity product) {
		ProductEntity pro = findById(id);
		if(pro != null) {
			pro.name = product.name;
			pro.quantity = product.quantity;
			pro.price = product.price;
		}
		return null;
	}

	public static void deleteProduct(Long id) {
		delete("id", id);
	}
	
	
}

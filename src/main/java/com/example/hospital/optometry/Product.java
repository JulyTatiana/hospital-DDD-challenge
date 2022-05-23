package com.example.hospital.optometry;

import co.com.sofka.domain.generic.Entity;
import com.example.hospital.optometry.values.ProductID;
import com.example.hospital.optometry.values.Price;

public class Product extends Entity<ProductID> {
    protected com.example.hospital.optometry.values.Product product;
    protected Price price;
    public Product(ProductID entityId, com.example.hospital.optometry.values.Product product, Price price) {
        super(entityId);
        this.product = product;
        this.price = price;
    }

    public com.example.hospital.optometry.values.Product product() {
        return product;
    }

    public void updateProduct(com.example.hospital.optometry.values.Product product) {
        this.product = product;
    }

    public Price price() {
        return price;
    }

    public void updatePrice(Price price) {
        this.price = price;
    }
}

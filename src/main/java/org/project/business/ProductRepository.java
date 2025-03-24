package org.project.business;

import org.project.domain.Product;

import java.util.List;

public interface ProductRepository {
    Product create(Product product);

    List<Product> findAll();

    void removeAll();

}

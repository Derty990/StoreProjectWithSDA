package org.project.business;

import org.project.domain.Product;

public interface ProductRepository {
    Product create(Product product);

    void removeAll();

}

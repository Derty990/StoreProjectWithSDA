package org.project.business;

import lombok.AllArgsConstructor;
import org.project.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product create(Product product) {

        return productRepository.create(product);

    }

    @Transactional
    public void removeAll(){
        productRepository.removeAll();

    }
}

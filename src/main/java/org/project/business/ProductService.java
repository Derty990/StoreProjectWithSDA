package org.project.business;

import lombok.AllArgsConstructor;
import org.project.domain.Opinion;
import org.project.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final OpinionService opinionService;
    private final PurchaseService purchaseService;
    private final ProductRepository productRepository;

    @Transactional
    public Product create(Product product) {

        return productRepository.create(product);

    }

    public List<Product> findAll() {

        return productRepository.findAll();

    }

    @Transactional
    public void removeAll() {
        productRepository.removeAll();

    }

    public Product find(String productCode) {

        return productRepository.find(productCode)
                .orElseThrow(() -> new RuntimeException("Product with product code: [%s] is missing".formatted(productCode)));

    }

    @Transactional
    public void removeCompletely(String productCode) {
        purchaseService.removeAllByProductCode(productCode);
        opinionService.removeAllByProductCode(productCode);
        productRepository.remove(productCode);
    }
}

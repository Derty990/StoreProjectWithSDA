package org.project.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void removeAll(){
        productRepository.removeAll();

    }

}

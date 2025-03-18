package org.project.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProducerService {

    private final ProductService productService;
    private final ProducerRepository producerRepository;

    public void removeAll(){
        productService.removeAll();
        producerRepository.removeAll();

    }

}



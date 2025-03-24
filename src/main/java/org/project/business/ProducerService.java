package org.project.business;

import lombok.AllArgsConstructor;
import org.project.domain.Producer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProducerService {

    private final ProductService productService;
    private final ProducerRepository producerRepository;

    @Transactional
    public Producer create(Producer producer) {
        return producerRepository.create(producer);
    }

    @Transactional
    public void removeAll(){
        productService.removeAll();
        producerRepository.removeAll();

    }
}



package org.project.business;

import lombok.AllArgsConstructor;
import org.project.domain.Purchase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Transactional
    public void removeAll(){
        purchaseRepository.removeAll();

    }

    @Transactional
    public Purchase create(Purchase purchase) {

        return purchaseRepository.create(purchase);

    }
}



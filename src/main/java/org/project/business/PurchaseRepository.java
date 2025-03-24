package org.project.business;

import org.project.domain.Purchase;

import java.util.List;

public interface PurchaseRepository {
    Purchase create(Purchase purchase);

    void removeAll();

    void removeAll(String email);

    List<Purchase> findAll(String email);

    List<Purchase> findAll(String email, String productCode);
}


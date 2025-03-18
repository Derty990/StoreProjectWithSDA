package org.project.business;

import org.project.domain.Purchase;

public interface PurchaseRepository {
    Purchase create(Purchase purchase);
}

package org.project.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.domain.Customer;
import org.project.domain.Product;
import org.project.domain.Purchase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class ShoppingCartService {

    private final CustomerService customerService;
    private final ProductService productService;
    private final PurchaseService purchaseService;

    @Transactional
    public void makeAPurchase(String email, String productCode, int quantity) {
        Customer customer = customerService.find(email);
        Product product = productService.find(productCode);
        Purchase purchase = purchaseService.create(Purchase.builder()
                .customer(customer)
                .product(product)
                .quantity(quantity)
                .dateTime(OffsetDateTime.now())
                .build());

        log.info("Customer: [{}] made a purchase for product: [{}], quantity: [{}]",
                email, productCode, quantity);
        log.debug("Customer: [{}] made a purchase for product: [{}], quantity: [{}], purchase: [{}]",
                email, productCode, quantity, purchase);

    }
}

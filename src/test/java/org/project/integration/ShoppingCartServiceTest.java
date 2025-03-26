package org.project.integration;


import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.project.business.*;
import org.project.domain.*;
import org.project.infrastructure.configuration.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(classes = ApplicationConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ShoppingCartServiceTest {

    private ReloadDataService reloadDataService;
    private ShoppingCartService shoppingCartService;
    private CustomerService customerService;
    private PurchaseService purchaseService;
    private OpinionService opinionService;
    private ProducerService producerService;
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        assertNotNull(reloadDataService);
        assertNotNull(shoppingCartService);
        assertNotNull(customerService);
        assertNotNull(purchaseService);
        assertNotNull(opinionService);
        assertNotNull(producerService);
        assertNotNull(productService);
        reloadDataService.reloadData();
    }

    @Test
    @DisplayName("thatProductCanBeBoughtByCustomer")
    void thatProductCanBeBoughtByCustomer(){
        //given

        final Customer customer = customerService.create(StoreFixtures.someCustomer());
        final Producer producer = producerService.create(StoreFixtures.someProducer());
        final Product product1 = productService.create(StoreFixtures.someProduct1(producer));
        productService.create(StoreFixtures.someProduct2(producer));
        final var before = purchaseService.findAll(customer.getEmail(), product1.getProductCode());

        //when

        shoppingCartService.makeAPurchase(customer.getEmail(), product1.getProductCode(), 10);

        //then
        final var after = purchaseService.findAll(customer.getEmail(), product1.getProductCode());
        assertEquals(before.size() + 1, after.size());




    }












}

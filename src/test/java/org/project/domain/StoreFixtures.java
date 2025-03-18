package org.project.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class StoreFixtures {

    public static Customer someCustomer(){
        return Customer.builder()
                .userName("kluczbartjava")
                .email("kluczb.bart@gmail.com")
                .name("bartosz")
                .surname("klucz")
                .dateOfBirth(LocalDate.of(2003,6,9))
                .telephoneNumber("+57821280189275")
                .build();
    }

    public static Producer someProducer() {

        return Producer.builder()
                .producerName("someProducer")
                .address("someAddress")
                .build();

    }

    public static Product someProduct1(Producer producer) {

        return Product.builder()
                .productCode("productCode1")
                .productName("productName1")
                .productPrice(BigDecimal.valueOf(3453.22))
                .adultsOnly(false)
                .description("someDescription")
                .producer(producer)
                .build();



    }

    public static Product someProduct2(Producer producer) {

        return Product.builder()
                .productCode("productCode2")
                .productName("productName2")
                .productPrice(BigDecimal.valueOf(678.21))
                .adultsOnly(false)
                .description("someDescription")
                .producer(producer)
                .build();

    }

    public static Purchase somePurchase(Customer customer, Product product1) {

        return Purchase.builder()
                .customer(customer)
                .product(product1)
                .quantity(2)
                .dateTime(OffsetDateTime.of(2020, 1, 1, 10, 9, 10, 1, ZoneOffset.ofHours(4)))
                .build();

    }

    public static Opinion someOpinion(Customer customer, Product product1) {

        return Opinion.builder()
                .customer(customer)
                .product(product1)
                .stars((byte) 4)
                .comment("My comment")
                .dateTime(OffsetDateTime.of(2020, 1, 1, 12, 9, 10, 1, ZoneOffset.ofHours(4)))
                .build();

    }
}

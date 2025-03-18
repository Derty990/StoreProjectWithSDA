package org.project.business;

import org.project.domain.Customer;

public interface CustomerRepository {
    Customer create(Customer customer);

    void removeAll();


}

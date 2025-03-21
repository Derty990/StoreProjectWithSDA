package org.project.business;

import lombok.AllArgsConstructor;
import org.project.domain.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private OpinionService opinionService;
    private PurchaseService purchaseService;
    private CustomerRepository customerRepository;

    @Transactional
    public Customer create(Customer customer){
        return customerRepository.create(customer);
    }

    @Transactional
    public void removeAll(){

        opinionService.removeAll();
        purchaseService.removeAll();
        customerRepository.removeAll();

    }

    public Customer find(String email) {

        return customerRepository.find(email)
                .orElseThrow(() -> new RuntimeException("Customer with email: [%s] is missing".formatted(email)));

    }

    @Transactional
    public void remove(String email) {

        Customer existingCustomer = find(email);

        opinionService.removeAll(email);

        purchaseService.removeAll(email);

        if(isOlderThan40(existingCustomer)){
            throw new RuntimeException(
                    "Could not remove customer because he/she is older than 40, email: [%s]".formatted(email));
        }

        customerRepository.remove(email);

    }

    private boolean isOlderThan40(Customer existingCustomer) {

        return LocalDate.now().getYear() - existingCustomer.getDateOfBirth().getYear() > 40;

    }


}

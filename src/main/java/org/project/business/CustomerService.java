package org.project.business;

import lombok.AllArgsConstructor;
import org.project.domain.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final OpinionService opinionService;
    private final PurchaseService purchaseService;
    private final CustomerRepository customerRepository;

    @Transactional
    public Customer create(Customer customer) {
        return customerRepository.create(customer);
    }

    @Transactional
    public void removeAll() {

        opinionService.removeAll();
        purchaseService.removeAll();
        customerRepository.removeAll();

    }

    public List<Customer> findAll() {

        return customerRepository.findAll();

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

        if (isOlderThan40(existingCustomer)) {
            throw new RuntimeException(
                    "Could not remove customer because he/she is older than 40, email: [%s]".formatted(email));
        }

        customerRepository.remove(email);

    }

    private boolean isOlderThan40(Customer existingCustomer) {

        return LocalDate.now().getYear() - existingCustomer.getDateOfBirth().getYear() > 40;

    }

    @Transactional
    public void removeUnwantedCustomers() {
        List<Customer> customers = customerRepository.findAll().stream()
                .filter(customer -> !isOlderThan40(customer))
                .filter(customer -> opinionService.customerGivesUnwantedOpinions(customer.getEmail()))
                .toList();

        customers.forEach(customer -> remove(customer.getEmail()));
    }
}

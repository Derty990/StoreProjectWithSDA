package org.project.infrastructure.database;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.business.CustomerRepository;
import org.project.domain.Customer;
import org.project.infrastructure.configuration.DatabaseConfiguration;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class CustomerDatabaseRepository implements CustomerRepository {

    private final SimpleDriverDataSource simpleDriverDataSource;

    @Override
    public Customer create(Customer customer) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(simpleDriverDataSource)
                .withTableName(DatabaseConfiguration.CUSTOMER_TABLE)
                .usingGeneratedKeyColumns(DatabaseConfiguration.CUSTOMER_TABLE_PKEY.toLowerCase());

        Number customerId = jdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(customer));
        /// casting to Long also does not work, intVaule() needs to be used
        return customer.withId((long) customerId.intValue());


    }
}

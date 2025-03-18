package org.project.infrastructure.database;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.business.ProductRepository;
import org.project.domain.Product;
import org.project.infrastructure.configuration.DatabaseConfiguration;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Slf4j
@Repository
@AllArgsConstructor
public class ProductDatabaseRepository implements ProductRepository {

    private final SimpleDriverDataSource simpleDriverDataSource;

    private final DatabaseMapper databaseMapper;

    @Override
    public Product create(Product product) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(simpleDriverDataSource)
                .withTableName(DatabaseConfiguration.PRODUCT_TABLE)
                .usingGeneratedKeyColumns(DatabaseConfiguration.PRODUCT_TABLE_PKEY.toLowerCase());

        Map<String, ?> params = databaseMapper.map(product);

        Number productId = jdbcInsert.executeAndReturnKey(params);
        return product.withId((long) productId.intValue());
    }
}

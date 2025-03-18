package org.project.infrastructure.database;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.business.PurchaseRepository;
import org.project.domain.Purchase;
import org.project.infrastructure.configuration.DatabaseConfiguration;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Slf4j
@Repository
@AllArgsConstructor
public class PurchaseDatabaseRepository implements PurchaseRepository {

    private final SimpleDriverDataSource simpleDriverDataSource;

    private final DatabaseMapper databaseMapper;

    @Override
    public Purchase create(Purchase purchase) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(simpleDriverDataSource)
                .withTableName(DatabaseConfiguration.PURCHASE_TABLE)
                .usingGeneratedKeyColumns(DatabaseConfiguration.PURCHASE_TABLE_PKEY.toLowerCase());

        Map<String, ?> params = databaseMapper.map(purchase);

        Number purchaseId = jdbcInsert.executeAndReturnKey(params);
        return purchase.withId((long) purchaseId.intValue());
    }
}

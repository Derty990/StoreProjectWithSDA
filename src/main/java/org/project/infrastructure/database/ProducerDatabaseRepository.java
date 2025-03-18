package org.project.infrastructure.database;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.business.ProducerRepository;
import org.project.domain.Producer;
import org.project.infrastructure.configuration.DatabaseConfiguration;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class ProducerDatabaseRepository implements ProducerRepository {

    private final SimpleDriverDataSource simpleDriverDataSource;

    @Override
    public Producer create(Producer producer) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(simpleDriverDataSource)
                .withTableName(DatabaseConfiguration.PRODUCER_TABLE)
                .usingGeneratedKeyColumns(DatabaseConfiguration.PRODUCER_TABLE_PKEY.toLowerCase());

        Number producerId = jdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(producer));
        return producer.withId((long) producerId.intValue());
    }
}

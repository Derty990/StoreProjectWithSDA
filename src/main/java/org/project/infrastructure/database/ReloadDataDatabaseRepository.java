package org.project.infrastructure.database;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.business.ReloadDataRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class ReloadDataDatabaseRepository implements ReloadDataRepository {

    private final SimpleDriverDataSource simpleDriverDataSource;

    @Override
    public void run(String sql) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);

        try{
            int result = jdbcTemplate.update(sql);
            log.debug("Inserted bootstrap data rows: [{}]",result);
        }catch (Exception e){
            log.error("Unable to run SQL Insert",e);
        }

    }
}

package org.project.business;

import org.springframework.stereotype.Repository;


public interface ReloadDataRepository {

    void run(String sql);

}

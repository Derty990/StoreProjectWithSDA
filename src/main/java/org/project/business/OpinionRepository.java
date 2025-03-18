package org.project.business;

import org.project.domain.Opinion;

public interface OpinionRepository {
    Opinion create(Opinion opinion);

    void removeAll();
}

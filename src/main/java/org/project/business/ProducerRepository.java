package org.project.business;

import org.project.domain.Producer;

import java.util.List;

public interface ProducerRepository {
    Producer create(Producer producer);

    List<Producer> findAll();

    void removeAll();
}

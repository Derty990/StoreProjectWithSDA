package org.project.business;

import org.project.domain.Producer;

public interface ProducerRepository {
    Producer create(Producer producer);

    void removeAll();
}

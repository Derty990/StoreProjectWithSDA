package org.project.business;

import lombok.AllArgsConstructor;
import org.project.domain.Opinion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OpinionService {

    private final OpinionRepository opinionRepository;

    public void removeAll() {
        opinionRepository.removeAll();

    }

    @Transactional
    public Opinion create(Opinion opinion) {

        return opinionRepository.create(opinion);

    }
}


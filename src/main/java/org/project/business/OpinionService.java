package org.project.business;

import lombok.AllArgsConstructor;
import org.project.domain.Opinion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public void removeAll(String email) {

        opinionRepository.remove(email);

    }

    public List<Opinion> findAll(String email) {
        return opinionRepository.findAll(email);
    }
}


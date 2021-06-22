package com.github.brunoabdon.daon.daoncore.persistence.repos;

import com.github.brunoabdon.daon.daoncore.persistence.entities.Apresentador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApresentadorRepository extends JpaRepository<Apresentador, Integer> {
}
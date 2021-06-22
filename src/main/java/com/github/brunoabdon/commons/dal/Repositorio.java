package com.github.brunoabdon.commons.dal;

import com.github.brunoabdon.commons.modelo.Identifiable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositorio<E extends Identifiable<I>, I>
            extends JpaRepository<E, I> {

}

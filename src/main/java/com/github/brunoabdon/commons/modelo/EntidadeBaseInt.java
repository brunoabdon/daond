package com.github.brunoabdon.commons.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

import static lombok.AccessLevel.PROTECTED;

/**
 * Classe base pra {@link Entidade}s com {@link Entidade#getId() id} do tipo
 * {@link Integer}.
 *
 * @author bruno
 */
@Getter
@Setter
@ToString
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@MappedSuperclass
public abstract class EntidadeBaseInt implements Entidade<Integer> {

    private static final long serialVersionUID = 5533865547017401869L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        EntidadeBaseInt that = (EntidadeBaseInt) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 179436940;
    }
}
package com.github.brunoabdon.daon.daoncore.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

import static com.github.brunoabdon.daon.daoncore.persistence.entities.Apresentador.DISCRIMINATOR_INSTITUICAO;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "daond")
@DiscriminatorValue(DISCRIMINATOR_INSTITUICAO)
public class Instituicao extends Apresentador {

    private static final long serialVersionUID = 4053060139359605828L;

    public Instituicao(final String nome) {
        super(nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Instituicao that = (Instituicao) o;

        return Objects.equals(getId(), that.getId());
    }

    /**
     * Retorna sempre um mesmo valor. Ver: <em>"<a
     * href="https://www.jpa-buddy.com/blog/lombok-and-jpa-what-may-go-wrong/"
     * >Lombok and JPA: What may go wrong?</a>"</em>.
     *
     * @return Um valor fixo.
     *
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        return 1901919697;
    }

    @Override
    public String toString() {
        return "Instituicao[" + getId() + "," + getNome() + "]";
    }
}
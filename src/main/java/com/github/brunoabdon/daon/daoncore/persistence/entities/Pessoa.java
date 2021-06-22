package com.github.brunoabdon.daon.daoncore.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

import static com.github.brunoabdon.daon.daoncore.persistence.entities.Apresentador.DISCRIMINATOR_PESSOA;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "daond")
@DiscriminatorValue(DISCRIMINATOR_PESSOA)
public class Pessoa extends Apresentador {
    private static final long serialVersionUID = 123312511576423167L;

    @ManyToOne
    private Apresentador apresentador;

    public Pessoa(final String nome){
        super(nome);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Pessoa pessoa = (Pessoa) o;

        return Objects.equals(getId(), pessoa.getId());
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
        return 526290239;
    }

    @Override
    public String toString() {
        return "Pessoa[" + getId() + "," + getNome() + "]";
    }
}
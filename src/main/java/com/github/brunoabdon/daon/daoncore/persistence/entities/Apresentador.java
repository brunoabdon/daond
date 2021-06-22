package com.github.brunoabdon.daon.daoncore.persistence.entities;

import com.github.brunoabdon.commons.modelo.EntidadeBaseInt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.DiscriminatorType.INTEGER;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name="apresentavel", discriminatorType = INTEGER)
//@DiscriminatorFormula(
//    "case when apresentador_id is not null "
//    + " then '" + Apresentador.DISCRIMINATOR_PESSOA + "'"
//    + " else '" + Apresentador.DISCRIMINATOR_INSTITUICAO + "'"
//    + " end"
//)
@Entity
@Table(schema = "daond")
public abstract class Apresentador extends EntidadeBaseInt {

    private static final long serialVersionUID = -2770750310746853461L;

    public static final String DISCRIMINATOR_PESSOA = "1";
    public static final String DISCRIMINATOR_INSTITUICAO = "0";

    @ToString.Include
    private String nome;

    @ToString.Exclude
    @OneToMany(mappedBy = "apresentador")
    private Set<Pessoa> apresentados;

    protected Apresentador(final String nome){
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Apresentador that = (Apresentador) o;

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
        return 2079803574;
    }

    @Override
    public String toString() {
        return "Apresentador[" + getId() + "," + getNome() + "]";
    }
}
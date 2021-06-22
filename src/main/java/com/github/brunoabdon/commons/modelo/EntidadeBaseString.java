package com.github.brunoabdon.commons.modelo;
/*
 * Copyright (C) 2017 Bruno Abdon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

import static lombok.AccessLevel.PROTECTED;

/**
 * Classe base pra {@link Entidade}s com {@link Entidade#getId() id} do tipo
 * {@link String}.
 *
 * @author bruno abdon
 */
@Getter
@Setter
@ToString
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@MappedSuperclass
public class EntidadeBaseString implements Entidade<String>{

    private static final long serialVersionUID = 3764778963499113464L;

	@Id
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        EntidadeBaseString that = (EntidadeBaseString) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1383772252;
    }
}

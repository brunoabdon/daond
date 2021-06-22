package com.github.brunoabdon.commons.facade.mappers;

import com.github.brunoabdon.commons.facade.EntidadeInexistenteException;

import java.io.Serializable;

public class IdMappingException extends EntidadeInexistenteException {

    private static final long serialVersionUID = 5848033307914949946L;

    public IdMappingException(final Class<?> tipo, final Serializable id) {
        super(tipo, id);
    }
}

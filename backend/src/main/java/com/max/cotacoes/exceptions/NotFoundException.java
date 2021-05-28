package com.max.cotacoes.exceptions;

import com.max.cotacoes.util.MessageUtils;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }

}

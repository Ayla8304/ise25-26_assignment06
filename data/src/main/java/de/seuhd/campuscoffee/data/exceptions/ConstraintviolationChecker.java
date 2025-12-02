package de.seuhd.campuscoffee.data.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.support.SQLExceptionSubclassTranslator;

public final class ConstraintViolationChecker {

    private ConstraintViolationChecker() {}

    public static boolean isConstraintViolation(Throwable e, String constraintName) {
        Throwable cause = e.getCause();
        while (cause != null) {
            String msg = cause.getMessage();
            if (msg != null && msg.contains(constraintName)) {
                return true;
            }
            cause = cause.getCause();
        }
        return false;
    }
}
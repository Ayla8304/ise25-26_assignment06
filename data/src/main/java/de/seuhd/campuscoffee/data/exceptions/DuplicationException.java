package de.seuhd.campuscoffee.data.exceptions;

public class DuplicationException extends RuntimeException {

    public DuplicationException(Class<?> type, String field, String value) {
        super(type.getSimpleName() + " with " + field + "=" + value + " already exists.");
    }
}

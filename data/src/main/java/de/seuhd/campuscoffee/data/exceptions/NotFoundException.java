package de.seuhd.campuscoffee.data.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Class<?> type, Long id) {
        super(type.getSimpleName() + " with id=" + id + " not found.");
    }

    public NotFoundException(Class<?> type, String field, String value) {
        super(type.getSimpleName() + " with " + field + "=" + value + " not found.");
    }
}

package com.example.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.function.Supplier;

@EqualsAndHashCode(callSuper = true)
@Data
public class ValueNotFoundException extends Exception implements Supplier<Exception> {

    public ValueNotFoundException() {
        super();
    }

    @Override
    public Exception get() {
        return this;
    }
}

package com.letsjam.business_objects.enums;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.Arrays;

public enum StatusEnum {

    OK ("OK"),

    KO ("KO"),

    KO_ALREADY_EXISTS("KO_ALREADY_EXISTS");

    private final String description;

    StatusEnum(final String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public static StatusEnum fromValue(final String v){
        return v == null ? null : Iterables.find(Arrays.asList(values()),
                new Predicate<StatusEnum>() {
                    @Override
                    public boolean apply(final StatusEnum input) {
                        return input.getDescription().equals(v);
                    }
                }, null);
    }
}

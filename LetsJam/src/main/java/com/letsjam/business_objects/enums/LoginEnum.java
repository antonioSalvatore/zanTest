package com.letsjam.business_objects.enums;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.Arrays;

public enum LoginEnum {

    //The values of the enum must be equals to the fields' name of the entity that we want to filter

    USERNAME("username"),

    PASSWORD("password");

    private final String description;

    LoginEnum(final String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public static LoginEnum fromValue(final String v){
        return v == null ? null : Iterables.find(Arrays.asList(values()),
                new Predicate<LoginEnum>() {
                    @Override
                    public boolean apply(final LoginEnum input) {
                        return input.getDescription().equals(v);
                    }
                }, null);
    }
}

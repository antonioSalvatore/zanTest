package com.letsjam.business_objects.enums;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.io.Serializable;
import java.util.Arrays;

public enum FilterFieldsEnum implements Serializable{

    //The values of the enum must be equals to the fields' name of the entity that we want to filter

    AGE("age"),

    CITY("city"),

    MUSICAL_INSTRUMENT("musicalInstrument");

    private final String description;

    FilterFieldsEnum(final String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public static FilterFieldsEnum fromValue(final String v){
        return v == null ? null : Iterables.find(Arrays.asList(values()),
                new Predicate<FilterFieldsEnum>() {
                    @Override
                    public boolean apply(final FilterFieldsEnum input) {
                        return input.getDescription().equals(v);
                    }
                }, null);
    }
}

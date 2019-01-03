package com.letsjam.business_objects.web;

import com.google.gson.annotations.Expose;
import com.letsjam.business_objects.enums.FilterFieldsEnum;

import java.util.Map;

public class FilterObject {

    @Expose
    private Map<String, String> filterFields;


    // --- GETTERS & SETTERS --- //

    public Map<String, String> getFilterFields() {
        return filterFields;
    }

    public void setFilterFields(Map<String, String> filterFields) {
        this.filterFields = filterFields;
    }


    // --- BUILDER --- //

    public static final class Builder {
        private Map<String, String> filterFields;

        private Builder() {
        }

        public static Builder aFilterObject() {
            return new Builder();
        }

        public Builder withFilterFields(Map<String, String> filterFields) {
            this.filterFields = filterFields;
            return this;
        }

        public Builder but() {
            return aFilterObject().withFilterFields(filterFields);
        }

        public FilterObject build() {
            FilterObject filterObject = new FilterObject();
            filterObject.setFilterFields(filterFields);
            return filterObject;
        }
    }
}

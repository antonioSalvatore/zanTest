package com.letsjam.business_objects.web;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class FilterObject {

    private List<String> filterFields;


    // --- GETTERS & SETTERS --- //

    public List<String> getFilterFields() {
        return filterFields;
    }

    public void setFilterFields(List<String> filterFields) {
        this.filterFields = filterFields;
    }


    // --- BUILDER --- //

    public static final class Builder {
        private List<String> filterFields;

        private Builder() {
        }

        public static Builder aFilterObject() {
            return new Builder();
        }

        public Builder withFilterFields(List<String> filterFields) {
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


    // --- EQUALS --- //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof FilterObject)) return false;

        FilterObject that = (FilterObject) o;

        final EqualsBuilder append = new EqualsBuilder();

        // this field is a list, and the persistent bags needs this
        if (filterFields != null && that.filterFields != null &&
                filterFields.size() == that.filterFields.size()) {
            List<String> tmpFilterFields = filterFields;
            for (int i = 0, tmpFilterFieldsSize = tmpFilterFields.size(); i < tmpFilterFieldsSize; i++) {
                String thisField = tmpFilterFields.get(i);
                String thatField = that.filterFields.get(i);
                append.append(thisField, thatField);
            }
        } else
            append.append(true, false);

        return append.isEquals();
    }


    // --- HASHCODE --- //

    @Override
    public int hashCode() {

        HashCodeBuilder append = new HashCodeBuilder(17, 37);
        // this field is a list, and the persistent bags needs this
        if(filterFields == null)
            append.append(filterFields);
        else{
            for(String element : filterFields){
                append.append(element);
            }
        }

        return append.toHashCode();
    }


    // --- TO STRING --- //

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("filterFields", filterFields)
                .toString();
    }
}

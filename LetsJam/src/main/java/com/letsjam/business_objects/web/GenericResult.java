package com.letsjam.business_objects.web;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class GenericResult<StatusEnum, T> {

    @Expose
    private StatusEnum status;

    @Expose
    private List<T> genericData;


    // --- GETTERS --- //

    public StatusEnum getStatus() {
        return status;
    }

    public List<T> getGenericData() {
        return genericData;
    }

    public T getSingleGenericData() {
        if (genericData != null && genericData.iterator().hasNext()) {
            return genericData.iterator().next();
        } else {
            return null;
        }
    }


    public static final class Builder<StatusEnum, T> {
        private StatusEnum status;
        private List<T> genericData;

        private Builder() {
        }

        public static <StatusEnum, T> Builder <StatusEnum, T> aGenericResult() {
            return new Builder<>();
        }

        public Builder <StatusEnum, T> withStatus(final StatusEnum status) {
            this.status = status;
            return this;
        }

        public Builder <StatusEnum, T> withGenericData(final List<T> genericData) {
            this.genericData = genericData;
            return this;
        }

        public Builder <StatusEnum, T> withGenericData(final T genericData) {
            final List<T> list = new ArrayList<>(1);
            list.add(genericData);
            final List<T> it = list;
            this.genericData = it;
            return this;
        }

        public GenericResult<StatusEnum, T> build() {
            final GenericResult<StatusEnum, T>  genericResult = new GenericResult<> ();
            genericResult.status = this.status;
            genericResult.genericData = this.genericData;
            return genericResult;
        }
    }
}

package com.letsjam.business_objects.web;

import com.google.gson.annotations.Expose;

public class GenericResult<StatusEnum, T> {

    @Expose
    private StatusEnum status;

    @Expose
    private T genericData;


    // --- GETTERS & SETTERS --- //

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public T getGenericData() {
        return genericData;
    }

    public void setGenericData(T genericData) {
        this.genericData = genericData;
    }


    public static final class Builder<StatusEnum, T> {
        private StatusEnum status;
        private T genericData;

        private Builder() {
        }

        public static <StatusEnum, T> Builder <StatusEnum, T> aGenericResult() {
            return new Builder<>();
        }

        public Builder <StatusEnum, T> withStatus(StatusEnum status) {
            this.status = status;
            return this;
        }

        public Builder <StatusEnum, T> withGenericData(T genericData) {
            this.genericData = genericData;
            return this;
        }

        public GenericResult<StatusEnum, T> build() {
            GenericResult<StatusEnum, T>  genericResult = new GenericResult<> ();
            genericResult.setStatus(status);
            genericResult.setGenericData(genericData);
            return genericResult;
        }
    }
}

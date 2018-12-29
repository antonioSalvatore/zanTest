package com.letsjam.business_objects.web;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class TransferObject<T> implements Serializable {

    private static final long serialVersionUID = 6192180042698023L;

    @Expose
    private T genericData;


    // --- GETTERS & SETTERS --- //

    public T getGenericData() {
        return genericData;
    }

    public void setGenericData(T genericData) {
        this.genericData = genericData;
    }


    // --- BUILDER --- //

    public static final class Builder<T> {
        private T genericData;

        private Builder() {
        }

        public static <T> Builder<T> aTransferObject() {
            return new Builder<>();
        }

        public Builder<T> withGenericData(T genericData) {
            this.genericData = genericData;
            return this;
        }

        public Builder<T> but() {
            return (Builder<T>) aTransferObject().withGenericData(genericData);
        }

        public TransferObject<T> build() {
            TransferObject<T> transferObject = new TransferObject<>();
            transferObject.genericData = this.genericData;
            return transferObject;
        }
    }
}

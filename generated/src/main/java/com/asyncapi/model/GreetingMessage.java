package com.asyncapi.model;

import javax.annotation.processing.Generated;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Hello world message
 */
@Generated(value="com.asyncapi.generator.template.spring", date="2024-03-28T11:36:11.582Z")
public class GreetingMessage {
    private @Valid GreetingPayload payload;

    public GreetingPayload getPayload() {
        return payload;
    }

    public void setPayload(GreetingPayload payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GreetingMessage event = (GreetingMessage) o;
        return Objects.equals(this.payload, event.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload);
    }

    @Override
    public String toString() {
        return "class GreetingMessage {\n" +
                "    payload: " + toIndentedString(payload) + "\n" +
                "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
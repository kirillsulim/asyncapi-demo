package com.asyncapi.model;


import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.processing.Generated;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Generated(value="com.asyncapi.generator.template.spring", date="2024-03-28T11:36:11.599Z")
public class GreetingPayload {
    
    private @Valid String greeting;
    

    

    
    @JsonProperty("greeting")@Pattern(regexp="^hello .+$")
    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GreetingPayload greetingPayload = (GreetingPayload) o;
        return 
            Objects.equals(this.greeting, greetingPayload.greeting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(greeting);
    }

    @Override
    public String toString() {
        return "class GreetingPayload {\n" +
        
                "    greeting: " + toIndentedString(greeting) + "\n" +
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
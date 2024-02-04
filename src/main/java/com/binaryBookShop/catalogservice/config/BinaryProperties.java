package com.binaryBookShop.catalogservice.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "binary")
// Marks the class as a source for configuration properties starting with the prefix “polar”
public class BinaryProperties {
    /*
    A message to welcome app users
     */

    private String greeting; //  Field for the custom polar.greeting (prefix + field name) property, parsed as String

    public String getGreeting() {
        return greeting;
    }

    public BinaryProperties setGreeting(String greeting) {
        this.greeting = greeting;
        return this;
    }
}

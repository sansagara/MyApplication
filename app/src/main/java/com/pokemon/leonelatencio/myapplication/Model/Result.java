package com.pokemon.leonelatencio.myapplication.Model;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private String url;
    private String name;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

}
package com.pokemon.leonelatencio.myapplication.Model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonFeed {

    private Long count;
    private Object previous;
    private List<Result> results = null;
    private String next;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }



    public Long getCount() {
        return count;
    }

    public Object getPrevious() {
        return previous;
    }

    public List<Result> getResults() {
        return results;
    }

    public String getNext() {
        return next;
    }

}
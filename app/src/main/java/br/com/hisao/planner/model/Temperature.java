package br.com.hisao.planner.model;


import java.util.HashMap;
import java.util.Map;

public class Temperature {

    private Integer max;
    private Integer min;
    private String unit;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

package com.work.with.kafka.simpleprojectkafka.model;

/**
 * @author Misha Malysh
 */
public class SimpleModel {

    private String field1;
    private String field2;

    public SimpleModel(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public SimpleModel() {}

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SimpleModel{");
        sb.append("field1= '").append(field1).append('\'');
        sb.append(", field2= '").append(field2).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

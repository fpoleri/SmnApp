package com.desi.SmnApp.exceptions;

public class ExceptionManager extends Exception {

    private static final long serialVersionUID = 3941221036411842318L;

    private String attribute;

    public ExceptionManager() {
        super();

    }

    public ExceptionManager(String message) {
        super(message);
    }

    public ExceptionManager(String message, String attribute) {
        super(message);
    }

    public String getAttribute() {
        return attribute;
    }

    public void seAtttribute(String attribute) {
        this.attribute = attribute;
    }
}

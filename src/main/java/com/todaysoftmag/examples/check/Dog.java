package com.todaysoftmag.examples.check;

/**
 * Class to illustrate checking params
 * 
 * @author bolog
 * 
 */
public class Dog {
    private String name;
    private String color;

    /**
     * 
     * @param name
     * @param color
     * @throws IllegalArgumentException
     *         if the name is <code>null</code>
     */
    public Dog(String name, String color) {
        checkParams(name);
        this.name = name;
        this.color = color;
    }

    private void checkParams(String name) {
        if (name == null) {
            throw new IllegalArgumentException("the dog must have a name!");
        }
    }
}

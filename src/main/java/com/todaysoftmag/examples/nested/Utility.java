package com.todaysoftmag.examples.nested;

import java.util.List;

import com.todaysoftmag.examples.objectmethods.Car;

/**
 * Small utility to illustrate nested statements.
 * 
 * @author bolog
 * 
 */
public class Utility {
    /**
     * print the elements of a cars list. There is no closing statement.
     * 
     * @param listOfCars
     */
    public static void printWithNested(List<Car> listOfCars) {
        if (listOfCars != null) {
            for (Car car : listOfCars) {
                if (car != null) {
                    System.out.println("car: " + car);
                } else {
                    System.out.println("car is null");
                }
            }
        }
    }

    /**
     * print the elements of a cars list. The closing statements are used wherever possible: return or continue
     * 
     * @param listOfCars
     */
    public static void printWithoutNested(List<Car> listOfCars) {
        if (listOfCars == null) {
            return;
        }
        for (Car car : listOfCars) {
            if (car == null) {
                System.out.println("car is null");
                continue;
            }
            System.out.println("car: " + car);
        }
    }
}

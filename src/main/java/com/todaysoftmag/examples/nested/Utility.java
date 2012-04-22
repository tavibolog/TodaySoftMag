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
    public static void printWithNested(List<Car> listOfCars) {
        if (listOfCars != null) {
            for (Car car : listOfCars) {
                if (car != null) {
                    System.out.println("car: " + car);
                }
            }
        }
    }

    public static void printWithoutNested(List<Car> listOfCars) {
        if (listOfCars == null) {
            return;
        }
        for (Car car : listOfCars) {
            if (car == null) {
                continue;
            }
            System.out.println("car: " + car);
        }
    }
}

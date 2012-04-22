package com.todaysoftmag.examples.objectmethods;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * unit test for {@link Car}
 * 
 * @author bolog
 * 
 */
public class CarTest {

    @Test
    public void testToString() {
        Car car = new Car("BMW", 5, false);
        assertTrue("Car[type=BMW,number of doors=5,isAllWheelDrive=false]".equals(car.toString()));
    }

    @Test
    public void testEqualCars() {
        Car firstCar = new Car("BMW", 3, false);
        Car secondCar = new Car("BMW", 3, false);

        assertTrue(firstCar.equals(secondCar));
    }

    @Test
    public void testFindCar() {
        List<Car> cars = new ArrayList<Car>();
        Car firstCar = new Car("BMW", 3, false);
        cars.add(firstCar);
        Car secondCar = new Car("Mercedes", 5, true);
        cars.add(secondCar);

        assertTrue(cars.indexOf(new Car("BMW", 3, false)) > -1);
    }

    @Test
    public void testNotEqualCars() {
        Car firstCar = new Car("Mercedes", 5, false);
        Car secondCar = new Car("BMW", 3, false);

        assertFalse(firstCar.equals(secondCar));
    }

    @Test
    public void testSameHashCodeForEqualCars() {
        Car firstCar = new Car("BMW", 3, false);
        Car secondCar = new Car("BMW", 3, false);

        assertTrue(firstCar.equals(secondCar));

        assertTrue(firstCar.hashCode() == secondCar.hashCode());
    }
}

package com.todaysoftmag.examples.objectmethods;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A POJO to show-case overriding equals, hashCode and toString from {@link Object}
 * 
 * @author bolog
 * 
 */
public class Car {
    private String type;
    private int numberOfDoors;
    private boolean isAllWheelDrive;

    /**
     * 
     * @param type
     * @param numberOfDoors
     * @param isAllWheelDrive
     * 
     */
    public Car(String type, int numberOfDoors, boolean isAllWheelDrive) {
        this.type = type;
        this.numberOfDoors = numberOfDoors;
        this.isAllWheelDrive = isAllWheelDrive;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!getClass().equals(object.getClass())) {
            return false;
        }

        Car car = (Car) object;

        return new EqualsBuilder().append(type, car.type).append(numberOfDoors, car.numberOfDoors)
                .append(isAllWheelDrive, car.isAllWheelDrive).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(numberOfDoors).append(isAllWheelDrive).toHashCode();
    }

    @Override
    public String toString() {
        ToStringBuilder tsb = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);

        return tsb.append("type", type).append("number of doors", numberOfDoors)
                .append("isAllWheelDrive", isAllWheelDrive).toString();
    }
}

package com.todaysoftmag.examples.check;

import org.junit.Test;

/**
 * test for {@link Dog}
 * @author bolog
 *
 */
public class DogTest {
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalDogName() {
        new Dog(null, "black");
    }


}

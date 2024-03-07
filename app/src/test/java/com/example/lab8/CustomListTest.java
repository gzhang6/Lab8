package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return CustomList
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        list = MockCityList();
        City city = mockCity();

        // add city and check has city
        list.addCity(city);
        assertTrue(list.hasCity(city));

        // check does not have city
        assertFalse(list.hasCity(new City("Regina", "Saskatchewan")));
    }

    @Test
    void testDelete() {
        list = MockCityList();
        City city = mockCity();

        // add city and check has city
        list.addCity(city);

        // Delete city
        list.delete(city);

        // After deletion
        assertFalse(list.hasCity(city));

        // Delete a non-existing city
        assertThrows(NoSuchElementException.class, () -> {
            list.delete(city);
        });
    }

    @Test
    void testCountCities() {
        list = MockCityList();
        list.addCity(new City("Calgary", "Alberta"));
        list.addCity(new City("Toronto", "Ontario"));
        assertEquals(2, list.countCities());
    }

}

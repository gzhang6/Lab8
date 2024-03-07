package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *the second phase, you can add the
     city * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * Checks if the specified city exists in the list.
     * @param city The city to check for existence.
     * @return true if the city exists in the list, false otherwise.
     */
    public boolean hasCity(City city) {
        for (int i = 0; i < cities.size(); i++) {
            if (Objects.equals(city.getCityName(), cities.get(i).getCityName()) && Objects.equals(city.getProvinceName(), cities.get(i).getProvinceName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes the specified city from the list.
     * @param city The city to be deleted.
     */
    public void delete(City city) throws NoSuchElementException {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new NoSuchElementException("City does not exist");
        }
    }

    /**
     * Returns the number of cities in the list.
     * @return The number of cities in the list.
     */
    public int countCities() {
        return cities.size();
    }
}

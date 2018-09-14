package com.zy.designs.mediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnitedNationsImpl implements UnitedNations{
    public List<Country> countries;

    public void setCountries(Country... countries){
        this.countries = Arrays.asList(countries);
    }

    @Override
    public void declare(String message, Country colleague) {
        for (Country country:countries){
            if (!countryEqual(country, colleague)){
                country.getMessage(message);
            }
        }
    }

    public Boolean countryEqual(Country country1,Country country2){
        return country1.getClass().getSimpleName().equals(country2.getClass().getSimpleName());
    }
}

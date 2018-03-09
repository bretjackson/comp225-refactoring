package edu.macalester.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }


    public  double charge() {
        return movie.charge(getDaysRented());
    }

    public int getFrequentRentalPoints(){
        // add frequent renter points
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if (this.getMovie().getPriceCode() == Movie.NEW_RELEASE && this.getDaysRented() > 1)
            frequentRenterPoints++;

        return frequentRenterPoints;
    }

}

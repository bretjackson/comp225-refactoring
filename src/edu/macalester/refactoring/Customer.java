package edu.macalester.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + getName() + "\n";
        for (Rental r : rentals) {
            double amount = 0;
            switch (r.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    amount += 2;
                    if (r.getDaysRented() > 2)
                        amount += (r.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    amount += r.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    amount += 1.5;
                    if (r.getDaysRented() > 3)
                        amount += (r.getDaysRented() - 3) * 1.5;
                    break;
            }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if (r.getMovie().getPriceCode() == Movie.NEW_RELEASE && r.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result += "\t" + r.getMovie().getTitle() + "\t" + String.valueOf(amount) + "\n";

            totalAmount += amount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }
}

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
        for (Rental rental : rentals) {
            double amount = rental.charge();


            frequentRenterPoints = rental.getFrequentRentalPoints();

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(amount) + "\n";

            totalAmount += amount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }

    public String htmlsStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "<html><h1>Rental record for " + getName() + "</h1>";
        for (Rental rental : rentals) {
            double amount = rental.charge();


            frequentRenterPoints = rental.getFrequentRentalPoints();

            // show figures for this rental
            result += "<p>\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(amount) + "</p>";

            totalAmount += amount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points</html>";

        return result;
    }

}

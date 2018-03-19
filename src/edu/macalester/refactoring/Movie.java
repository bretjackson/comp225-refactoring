package edu.macalester.refactoring;

public class Movie {

    public static final int SCIFI = 3;
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private PriceCode priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        if (priceCode == Movie.CHILDREN)
            this.priceCode = new ChildrenPrice();
    }


    public String getTitle() {
        return title;
    }

    public double calcFee(int daysRented){
        return priceCode.getPrice(daysRented);
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public int getFrequentPoints(int daysRented){
        if ((priceCode == Movie.NEW_RELEASE || priceCode== Movie.SCIFI) && daysRented > 1){
            return 2;
        }
        else {
            return 1;
        }
    }

}

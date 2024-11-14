package fr.uge.jee.onlineshop;

public class Standard implements Delivery{
    private final int numberOfDays;

    public Standard(int numberOfDays){
        this.numberOfDays = numberOfDays;
    }
    @Override
    public String description() {
        return "Standard Delivery with a delay of " + numberOfDays + " days";
    }
}

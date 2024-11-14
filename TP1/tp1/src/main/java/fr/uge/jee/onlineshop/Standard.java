package fr.uge.jee.onlineshop;

public class Standard implements Delivery{
    @Override
    public String description() {
        return "Standard Delivery with a delay of 5 days";
    }
}

package fr.uge.jee.annotations.onlineshop;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Standard implements Delivery{


    private int numberOfDays;

    public Standard(@Value("${onlineshop.standarddelivery.delay}") int numberOfDays){
        this.numberOfDays = numberOfDays;
    }
    @Override
    public String description() {
        return "Standard Delivery with a delay of " + numberOfDays + " days";
    }
}

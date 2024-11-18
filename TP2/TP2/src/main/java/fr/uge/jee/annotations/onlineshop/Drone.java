package fr.uge.jee.annotations.onlineshop;

import org.springframework.stereotype.Component;

@Component
public class Drone implements Delivery{
    @Override
    public String description() {
        return "Delivery by Drone";
    }
}

package fr.uge.jee.onlineshop;

public class Drone implements Delivery{
    @Override
    public String description() {
        return "Delivery by Drone";
    }
}

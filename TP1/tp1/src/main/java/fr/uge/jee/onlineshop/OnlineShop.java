package fr.uge.jee.onlineshop;

import java.util.Set;

public class OnlineShop {

    private String name;
    private Set<Delivery> deliveryOptions;
    private Set<Insurance> insurances;


    public void printDescription(){
        System.out.println(name);
        System.out.println("Delivery options");
        deliveryOptions.forEach(opt -> System.out.println("\t"+opt.description()));
        System.out.println("Insurance options");
        insurances.forEach(insurance -> System.out.println("\t"+insurance.description()));
    }
}
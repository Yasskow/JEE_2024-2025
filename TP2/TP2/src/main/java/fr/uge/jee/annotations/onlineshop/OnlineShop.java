package fr.uge.jee.annotations.onlineshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

@Component
public class OnlineShop {
//    @Value("${onlineshop.name}")
    private String name;
//    @Autowired
    private Set<Delivery> deliveryOptions;
//    @Autowired
    private Set<Insurance> insurances;

    public OnlineShop(@Value("${onlineshop.name}") String name, @Autowired Set<Delivery> deliveryOptions, @Autowired Set<Insurance> insurances){
        this.name = Objects.requireNonNull(name);
        this.deliveryOptions = Objects.requireNonNull(deliveryOptions);
        this.insurances = Objects.requireNonNull(insurances);
    }


    public void printDescription(){
        System.out.println(name);
        System.out.println("Delivery options");
        deliveryOptions.forEach(opt -> System.out.println("\t"+opt.description()));
        System.out.println("Insurance options");
        insurances.forEach(insurance -> System.out.println("\t"+insurance.description()));
    }
}
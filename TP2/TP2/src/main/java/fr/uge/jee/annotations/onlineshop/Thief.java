package fr.uge.jee.annotations.onlineshop;

import org.springframework.stereotype.Component;

@Component
public class Thief implements Insurance{

    @Override
    public String description() {
        return "Thief insurance";
    }
}

package fr.uge.jee.annotations.onlineshop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Set;

@Configuration
@ComponentScan("fr.uge.jee.annotations")
@PropertySource("classpath:onlineshop.properties")
public class Config {

//    @Bean
//    Insurance insuranceReturn(){
//        return new Return();
//    }
//    @Bean
//    Insurance insuranceThief(){
//        return new Thief();
//    }
//    @Bean
//    Delivery deliveryOption(){
//        return new Standard(999);
//    }
//    @Bean
//    OnlineShop onlineShop(){
//        return new OnlineShop();
//    }
}

package fr.uge.jee.onlineshop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("config-onlineshop.xml");
//        var shop = context.getBean("shop", fr.uge.jee.onlineshop.OnlineShop.class);
//        shop.printDescription();
        ApplicationContext context = new ClassPathXmlApplicationContext("config-onlineshop.xml");
        var shop = context.getBean("fr.uge.jee.onlineshop.OnlineShop", fr.uge.jee.onlineshop.OnlineShop.class);
        shop.printDescription();
    }
}
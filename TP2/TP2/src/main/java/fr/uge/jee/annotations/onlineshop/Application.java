package fr.uge.jee.annotations.onlineshop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext appli = new AnnotationConfigApplicationContext(Config.class);
        var test = appli.getBean("onlineShop", OnlineShop.class);
        test.printDescription();
    }
}

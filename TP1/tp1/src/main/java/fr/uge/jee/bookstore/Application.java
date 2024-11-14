package fr.uge.jee.bookstore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config-bookstore.xml");
        var library = context.getBean("library", fr.uge.jee.bookstore.Library.class);
        System.out.println(library.toString());

        var constLibrary = context.getBean("autowire", fr.uge.jee.bookstore.Library.class);
        constLibrary.toString();
    }
}

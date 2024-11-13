package fr.uge.jee.printers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config-printers.xml");
        var getSimpleMessageBean = context.getBean("printMessage", fr.uge.jee.printers.SimpleMessagePrinter.class);
        var getFrenchMessageBean = context.getBean("frenchMessage", fr.uge.jee.printers.FrenchMessagePrinter.class);
        var getCustomMessageBean = context.getBean("customMessage", fr.uge.jee.printers.CustomizableMessagePrinter.class);
        var getSlowMessageBean = context.getBean("slowMessage", fr.uge.jee.printers.SlowConstructionMessagePrinter.class);

        getSimpleMessageBean.printMessage();
        getFrenchMessageBean.printMessage();
        getCustomMessageBean.printMessage();
        MessagePrinter printer = context.getBean("counterMessage",MessagePrinter.class);
        printer.printMessage();
        printer.printMessage();
        printer.printMessage();
        MessagePrinter printer2 =  context.getBean("counterMessage",MessagePrinter.class);
        printer2.printMessage();



        getSlowMessageBean.printMessage();
    }
}

/**
 * Le constructeur appelé est celui sans paramètre (c'est celui choisi par défaut)
 *
 * Le design pattern mis en place dans ce cas est le : Singleton
 * En créant une deuxième variable, on s'attendait à ce qu'il recommence à 0 mais il a continué.
 *
 * Les beans sont instanciés au moment de la création du ApplicationContext
 * */
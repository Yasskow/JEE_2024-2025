package fr.uge.jee.printers;

public class SlowConstructionMessagePrinter implements MessagePrinter{
    public SlowConstructionMessagePrinter() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Override
    public void printMessage() {
        System.out.println("SLOW WORLD ....");
    }
}

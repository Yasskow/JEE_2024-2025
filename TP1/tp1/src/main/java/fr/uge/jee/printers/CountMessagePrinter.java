package fr.uge.jee.printers;

public class CountMessagePrinter implements MessagePrinter{
    private int count;

    @Override
    public void printMessage() {
        System.out.println("This message number " + this.count++);
    }
}

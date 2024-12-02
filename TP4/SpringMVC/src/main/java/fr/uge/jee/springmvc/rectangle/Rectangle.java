package fr.uge.jee.springmvc.rectangle;

public class Rectangle {
    private int height;
    private int width;

    Rectangle(){
    }

    Rectangle(int height, int width){
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int area(){
        return height * width;
    }
}

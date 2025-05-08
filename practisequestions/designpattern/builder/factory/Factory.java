package practisequestions.designpattern.builder.factory;

interface Shape{
    void draw();
}

class Circle implements Shape{
    public void draw(){
        System.out.println("circle");
    }
}

class Square implements Shape {
    public void draw(){
        System.out.println("Square");
    }
}

public class Factory {
    public Shape getShape(String type) {
        return switch (type){
            case "circle" -> new Circle();
            case "square" -> new Square();
            default -> null;
        };
    }
}

package structural;

interface DrawingAPI {
    void draw(int x, int y, int radius);
}

class DrawingAPI1 implements DrawingAPI {

    @Override
    public void draw(int x, int y, int radius) {
        System.out.println("draw 1");
    }
}

class DrawingAPI2 implements DrawingAPI {

    @Override
    public void draw(int x, int y, int radius) {
        System.out.println("draw 2");
    }
}

abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();
}

class DrawCircle extends Shape {
    private int x,y,radius;

    protected DrawCircle(int x, int y, int radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        this.drawingAPI.draw(this.x, this.y, this.radius);
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        DrawingAPI drawingAPI = new DrawingAPI1();

        Shape shape = new DrawCircle(10, 22, 3, drawingAPI);

        shape.draw();
    }
}

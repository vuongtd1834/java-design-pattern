package structural;

interface Coffee {
    double cost();
    String description();
}

class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 2;
    }

    @Override
    public String description() {
        return "Simple coffee";
    }
}

class CoffeeDecorator implements Coffee {
    private final Coffee coffeeDecorator;

    public CoffeeDecorator(Coffee coffee) {
        this.coffeeDecorator = coffee;
    }

    @Override
    public double cost() {
        return coffeeDecorator.cost();
    }

    @Override
    public String description() {
        return coffeeDecorator.description();
    }
}

class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 1;
    }

    @Override
    public String description() {
        return super.description() + " with milk";
    }
}

class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }

    @Override
    public String description() {
        return super.description() + " with sugar";
    }
}


public class Decorator {
    public static void main(String[] args) {
        SimpleCoffee coffee = new SimpleCoffee();
        CoffeeDecorator milk = new MilkDecorator(coffee);
        CoffeeDecorator sugar = new SugarDecorator(coffee);
        System.out.println(coffee.description() + " cost " + coffee.cost());
        System.out.println(milk.description() + " cost " + milk.cost());
        System.out.println(sugar.description() + " cost " + sugar.cost());
    }
}

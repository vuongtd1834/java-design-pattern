package creation;

interface Animal {
    void sound();
}

class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Gau Gau");
    }
}

class Chicken implements Animal {

    @Override
    public void sound() {
        System.out.println("Quack Quack");
    }
}

interface AnimalFactory {
    Animal creatAnimal();
}

class DogFactory implements AnimalFactory {

    @Override
    public Animal creatAnimal() {
        return new Dog();
    }
}

class ChickenFactory implements  AnimalFactory {

    @Override
    public Animal creatAnimal() {
        return new Chicken();
    }
}

class TestFactory {

    private String type;

    public TestFactory() {
        this.type = "Dog";
    }

    public TestFactory(String type) {
        this.type = type;
    }

    public Animal createAnimal() {
        if (type.equals("chicken")) {
            return new Chicken();
        }
        return new Dog();
    }
}


public class FactoryPattern {
    public static void main(String[] args) {
        TestFactory testFactory = new TestFactory("Dog");
        Animal animal = testFactory.createAnimal();
        if (animal instanceof Chicken) {
            System.out.println("Instance is Dog");
        }
        animal.sound();
    }
}

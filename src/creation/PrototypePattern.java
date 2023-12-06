package creation;

class ConcretePrototype implements Cloneable {
    private String data;

    @Override
    public ConcretePrototype clone() {
        try {
            return (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        ConcretePrototype concretePrototype = new ConcretePrototype();
        concretePrototype.setData("test");
        System.out.println(concretePrototype.getData());

        ConcretePrototype concretePrototype1 = concretePrototype.clone();
        concretePrototype1.setData("test1");
        concretePrototype.setData("test11");
        System.out.println(concretePrototype.equals(concretePrototype1));
    }
}

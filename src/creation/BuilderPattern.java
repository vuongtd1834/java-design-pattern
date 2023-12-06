package creation;

class Computer {
    private String CPU;
    private String RAM;

    private String storage;

    public Computer(String CPU, String RAM, String storage) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}

interface ComputerBuilder {
    ComputerBuilder setCPU(String cpu);
    ComputerBuilder setRAM(String ram);

    ComputerBuilder setStorage(String storage);

    Computer build();
}

class DeskTopBuilder implements ComputerBuilder {

    Computer computer;

    public DeskTopBuilder() {
        this.computer = new Computer("", "", "");
    }

    @Override
    public ComputerBuilder setCPU(String cpu) {
        computer = new Computer(cpu, this.computer.getRAM(), this.computer.getStorage());
        return this;
    }

    @Override
    public ComputerBuilder setRAM(String ram) {
        computer = new Computer(this.computer.getCPU(), ram, this.computer.getStorage());
        return this;
    }

    @Override
    public ComputerBuilder setStorage(String storage) {
        computer = new Computer(this.computer.getCPU(), this.computer.getRAM(), storage);
        return this;
    }

    @Override
    public Computer build() {
        return computer;
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        ComputerBuilder comp = new DeskTopBuilder();
        ComputerBuilder comp2 = new DeskTopBuilder();
        Computer computer = comp.setCPU("CORE I9").setRAM("32 GB").setStorage("1T").build();
        Computer computer2 = comp2.setCPU("CORE I7").setRAM("16 GB").build();

        System.out.println("Computer have CPU: " + computer.getCPU() + " RAM: " + computer.getRAM() + " Storage: " + computer.getStorage());
        System.out.println("Computer 2 have CPU: " + computer2.getCPU() + " RAM: " + computer2.getRAM() + " Storage: " + computer2.getStorage());
    }
}

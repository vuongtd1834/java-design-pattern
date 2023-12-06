package creation;
public class SingletonPattern {
    private static SingletonPattern instance;
    public String name;

    private SingletonPattern() {}

    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }
}
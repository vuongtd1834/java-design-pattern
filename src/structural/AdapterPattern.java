package structural;

interface Target {
    void request();
}

class Source {
    public void specificRequest() {
        System.out.println("Specific request!");
    }
}

class Adapter implements Target {

    Source source;

    public Adapter(Source source) {
        this.source = source;
    }

    @Override
    public void request() {
        source.specificRequest();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Source());
        adapter.request();
    }
}

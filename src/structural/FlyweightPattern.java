package structural;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractKeyLabel {
    private String key;

    public AbstractKeyLabel(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}

class PhaseScenario extends AbstractKeyLabel {
    private static final Map<String, PhaseScenario> map = new HashMap<>();
    public PhaseScenario(String key) {
        super(key);
    }
    public static PhaseScenario getInstance(String key) {
        PhaseScenario phaseScenario = map.get(key);
        if (phaseScenario == null) {
            phaseScenario = new PhaseScenario(key);
            map.put(key, phaseScenario);
        }
        return phaseScenario;
    }
    public static final PhaseScenario TEST = new PhaseScenario("TEST");
    public static final PhaseScenario TEST_2 = new PhaseScenario("TEST_2");
}

public class FlyweightPattern {
    public static void main(String[] args) {
        System.out.println(PhaseScenario.TEST.getKey());
        System.out.println(PhaseScenario.getInstance("TEST").getKey());
        System.out.println(PhaseScenario.getInstance("TEST_2").getKey());
    }
}

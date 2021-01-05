package lesson5_Core;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    Boolean win;

    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        win = false;
    }
}

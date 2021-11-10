package facebook.yoga.internal;

import java.util.EnumSet;
import java.util.Set;

public class GlobalMembers {

    private static final Set<Experiment> enabledExperiments = EnumSet.noneOf(Experiment.class);

    public static void enable(Experiment experiment) {
        enabledExperiments.add(experiment);
    }

    public static void disable(Experiment experiment) {
        enabledExperiments.remove(experiment);
    }

    public static boolean toggle(Experiment experiment) {
        if (enabledExperiments.contains(experiment)) {
            return enabledExperiments.remove(experiment);
        } else {
            enabledExperiments.add(experiment);
            return false;
        }
    }

    public static boolean isEnabled(Experiment experiment) {
        return enabledExperiments.contains(experiment);
    }

    public static void disableAllExperiments() {
        enabledExperiments.clear();
    }
}

package facebook.yoga.internal;

import java.util.EnumSet;
import java.util.Set;

public enum Experiment {

    kDoubleMeasureCallbacks;

    private static final Set<Experiment> ENABLED_EXPERIMENTS = EnumSet.noneOf(Experiment.class);

    public void enable() {
        ENABLED_EXPERIMENTS.add(this);
    }

    public void disable() {
        ENABLED_EXPERIMENTS.remove(this);
    }

    public boolean toggle() {
        if (ENABLED_EXPERIMENTS.contains(this)) {
            return ENABLED_EXPERIMENTS.remove(this);
        } else {
            ENABLED_EXPERIMENTS.add(this);
            return false;
        }
    }

    public boolean isEnabled() {
        return ENABLED_EXPERIMENTS.contains(this);
    }

    public static void disableAllExperiments() {
        ENABLED_EXPERIMENTS.clear();
    }
}

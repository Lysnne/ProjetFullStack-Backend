package ikasaidi.backend.job;

import java.util.Timer;

public class ScheduleModif {
    private Timer timer;

    public ScheduleModif(int delay, int period){
        timer =  new Timer();
        timer.schedule(new ModificationAction(), delay, period);

    }

}

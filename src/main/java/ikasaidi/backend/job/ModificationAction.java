package ikasaidi.backend.job;

import java.util.TimerTask;
import java.util.logging.Logger;

public class ModificationAction extends TimerTask {

    Logger logger = Logger.getLogger(ModificationAction.class.getName());


    @Override
    public void run() {
        try {
            //Faudrais une limite
            int modif = (int) (Math.random());

        }catch (Exception e){
            logger.info(e.getMessage());
        }
    }
}

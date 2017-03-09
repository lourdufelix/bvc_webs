package org.tirava.restfulapi.machinehelper.Event;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Created by maheedharan on 3/5/17.
 */
public class MachineHelperLifeCyle implements CommandLineRunner {

    static Logger LOGGER = Logger.getLogger(MachineHelperLifeCyle.class.getName());

    @Override
    public void run(String... arg0) throws Exception {
        LOGGER.info("MachineHelper Application has started");
    }

    @PreDestroy
    public void onExit() {
        LOGGER.info("MachineHelper Application has stopped");

    }
}

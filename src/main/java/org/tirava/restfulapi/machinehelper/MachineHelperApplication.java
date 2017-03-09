package org.tirava.restfulapi.machinehelper;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MachineHelperApplication {

	static Logger LOGGER = Logger.getLogger(MachineHelperApplication.class.getName());
	public static void main(String[] args) {

		SpringApplication.run(MachineHelperApplication.class, args).registerShutdownHook();
	}
	public void preDestroy() {
		LOGGER.info("MachineHelper Application has stopped");
	}
}

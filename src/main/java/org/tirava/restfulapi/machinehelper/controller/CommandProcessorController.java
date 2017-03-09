package org.tirava.restfulapi.machinehelper.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tirava.restfulapi.machinehelper.Global.Constants;
import org.tirava.restfulapi.machinehelper.Global.StaticConfiguration;
import org.tirava.restfulapi.machinehelper.entity.CommandRequestVO;
import org.tirava.restfulapi.machinehelper.entity.CommandVO;
import org.tirava.restfulapi.machinehelper.service.CommandConfigLoaderService;
import org.tirava.restfulapi.machinehelper.service.CommandProcessorService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller Class to process the request to execute commands
 * in the machine and respond back with the response text.
 */
@RestController
public class CommandProcessorController {

    @Autowired
    private CommandConfigLoaderService cmdLoader;

    static Logger LOGGER = Logger.getLogger(CommandConfigLoaderService.class.getName());

    @RequestMapping(value="/executeCommand", method = RequestMethod.POST)
    public  String executeCommand(@RequestBody CommandRequestVO commandRequestVO)
    {



        String responseText = Constants.EMPTY_STING;

        String cmdName = commandRequestVO.getCommandName();

        LOGGER.info("Executing Command : " + cmdName);

        if(cmdName!=null && !cmdName.equals(Constants.EMPTY_STING)) {

            CommandVO cmdObj = StaticConfiguration.CmdConfigMap.get(cmdName);

            if (cmdObj != null) {
                List<String> cmdBuilder = new ArrayList<String>();

                cmdBuilder.add(cmdObj.getCommand());
                cmdObj.getArguments().forEach(args -> cmdBuilder.add(args));

                CommandProcessorService commandProcessor = new CommandProcessorService();

                try {

                    responseText = commandProcessor.Execute(cmdBuilder);

                } catch (IOException e) {
                    responseText = "API encountered error while executing command. See API Logs for more details";
                    e.printStackTrace();
                }
            } else {
                responseText = "COMMAND " + cmdName + "NOT CONFIGURED IN API";
            }
        }
        else
        {
            responseText = "API ERR: Missing Command Name in the Request";
        }
        return responseText;
    }
}

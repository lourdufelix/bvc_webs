package org.tirava.restfulapi.machinehelper.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.tirava.restfulapi.machinehelper.Global.StaticConfiguration;
import org.tirava.restfulapi.machinehelper.entity.CommandConfigVO;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * Created by maheedharan on 3/5/17.
 */
@Service
public class CommandConfigLoaderService {

    @Value("${json.commandconfig.file}")
    String cmdConfigFile;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();

        CommandConfigVO commandList = jsonMapper.readValue(new File(cmdConfigFile), CommandConfigVO.class);

        System.out.println("No of commands in configuration file: " + commandList.getCommands().size());

        commandList.getCommands().forEach(command -> StaticConfiguration.CmdConfigMap.put(command.getName(), command));

    }

}

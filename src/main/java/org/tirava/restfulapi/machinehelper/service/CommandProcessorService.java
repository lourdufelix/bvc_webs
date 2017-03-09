package org.tirava.restfulapi.machinehelper.service;

import org.springframework.stereotype.Service;
import org.tirava.restfulapi.machinehelper.Global.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by maheedharan on 3/5/17.
 */
@Service
public class CommandProcessorService {
    public String Execute(List command) throws IOException
    {
        String Output = Constants.EMPTY_STING;

        ProcessBuilder builder = new ProcessBuilder(command);

        Process p = builder.start();

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        String cmdOutputStringLine;

        while ((cmdOutputStringLine = stdInput.readLine()) != null) {

            Output = Output + cmdOutputStringLine + Constants.NEWLINE;
        }


        while ((cmdOutputStringLine = stdError.readLine()) != null) {

            Output = Output + cmdOutputStringLine + Constants.NEWLINE;
        }

        return Output;
    }
}

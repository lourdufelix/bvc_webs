package org.tirava.restfulapi.machinehelper.entity;

/**
 * Created by maheedharan on 3/4/17.
 */
public class CommandRequestVO {

    private RequestHeaderVO requestHeaderVO;

    private String commandName;

    private boolean debug;
    private boolean backgroundExecution;

    public RequestHeaderVO getRequestHeaderVO() {
        return requestHeaderVO;
    }

    public String getCommandName() {
        return commandName;
    }

    public boolean isDebug() {
        return debug;
    }

    public boolean isBackgroundExecution() {
        return backgroundExecution;
    }
}

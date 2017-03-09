package org.tirava.restfulapi.machinehelper.Global;

import org.tirava.restfulapi.machinehelper.entity.CommandVO;

import java.util.HashMap;

/**
 * Created by maheedharan on 3/5/17.
 */
public class StaticConfiguration {

    public static HashMap<String, CommandVO> CmdConfigMap = new HashMap<String, CommandVO>();
    public static HashMap<String, CommandVO> CmdConfigMapCache = new HashMap<String, CommandVO>();

    public static int CmdConfigActiveReadCount;
    public static int CmdConfigCacheActiveReadCount;

    public static void setCmdConfigMap(HashMap<String, CommandVO> cmdConfigMap) {
        CmdConfigMap = cmdConfigMap;
    }

    public static void setCmdConfigMapCache(HashMap<String, CommandVO> cmdConfigMapCache) {
        CmdConfigMapCache = cmdConfigMapCache;
    }

    public static void setCmdConfigActiveReadCount(int cmdConfigActiveReadCount) {
        CmdConfigActiveReadCount = cmdConfigActiveReadCount;
    }

    public static void setCmdConfigCacheActiveReadCount(int cmdConfigCacheActiveReadCount) {
        CmdConfigCacheActiveReadCount = cmdConfigCacheActiveReadCount;
    }

}

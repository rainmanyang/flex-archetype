package com.oasis.wolfburg.common.vo.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WSMessage implements Serializable {

    private static final long serialVersionUID = -3487332797160438151L;

    private String target;

    private int execFlag = 0;

    private String message = null;

    private List<String> targetList = new ArrayList<String>();

    public List<String> getTargetList() {
        return targetList;
    }

    public void setTargetList(List<String> targetList) {
        this.targetList = targetList;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getExecFlag() {
        return execFlag;
    }

    public void setExecFlag(int execFlag) {
        this.execFlag = execFlag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

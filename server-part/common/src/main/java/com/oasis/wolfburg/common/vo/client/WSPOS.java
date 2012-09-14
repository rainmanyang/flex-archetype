package com.oasis.wolfburg.common.vo.client;

import java.io.Serializable;

public class WSPOS implements Serializable {

    private static final long serialVersionUID = -5870096595823105370L;

    /**
     * 网点Id
     */
    private Long id;

    /**
     * 网点名称
     */
    private String name;

    /**
     * 路书
     */
    private String roadMap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoadMap() {
        return roadMap;
    }

    public void setRoadMap(String roadMap) {
        this.roadMap = roadMap;
    }

}

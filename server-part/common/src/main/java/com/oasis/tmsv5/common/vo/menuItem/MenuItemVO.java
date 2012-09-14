package com.oasis.tmsv5.common.vo.menuItem;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.type.MenuType;

public class MenuItemVO extends BaseVO {

    private static final long serialVersionUID = 6440943617383720938L;

    private Long id;

    private String action;

    private Long sortIndex;

    private String location;

    private String name;

    private Long parentId;

    private String title;

    private String titleen;

    private MenuType type;
    
    /**
     * 网络访问权限
     * 三位
     * 比如：“000”、“111”
     * 第一个0表示内网不可以访问,1表示内网可以访问
     * 第二个0表示VPN不可以访问，1表示VPN可以访问
     * 第三个0表示外网不可以访问，1表示外网可以访问
     */
    private String netAuthority;

    public Long getId() {
        return id;
    }

    public String getNetAuthority() {
        return netAuthority;
    }

    public void setNetAuthority(String netAuthority) {
        this.netAuthority = netAuthority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Long sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public String getTitleen() {
        return titleen;
    }

    public void setTitleen(String titleen) {
        this.titleen = titleen;
    }

}

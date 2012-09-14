package com.oasis.tmsv5.model.menuItem;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import com.oasis.wolfburg.common.enums.type.MenuType;

@Table(name = "GT_MENU_ITEM")
public class MenuItem implements Serializable {

    private static final long serialVersionUID = 6440943617383720938L;

    private Long id;

    private String action;

    private Long sortIndex;

    private String location;

    private String name;

    private Long parentId;

    private String title;

    private MenuType type;
    
    private String netAuthority;

    @Id
    public Long getId() {
        return id;
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

    @Override
    public int hashCode() {
        return Integer.parseInt(getId().toString());
    }

    @Override
    public boolean equals(Object obj) {

        return getId() == ((MenuItem) obj).getId();
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

	public String getNetAuthority() {
		return netAuthority;
	}

	public void setNetAuthority(String netAuthority) {
		this.netAuthority = netAuthority;
	}
    
    

}

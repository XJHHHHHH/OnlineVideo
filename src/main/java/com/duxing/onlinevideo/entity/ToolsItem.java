package com.duxing.onlinevideo.entity;/*
 * Welcome to use the TableGo Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author:bianj
 * Email:edinsker@163.com
 * Version:5.8.0
 */

/**
 * TOOLS_ITEM
 * 
 * @author bianj
 * @version 1.0.0 2021-03-12
 */
public class ToolsItem implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 3868171131813881445L;

    /** id */
    private Integer id;

    /** name */
    private String name;

    /** toolsUrl */
    private String toolsUrl;

    /** iconUrl */
    private String iconUrl;

    /** toolTypeId */
    private Integer toolTypeId;

    /**
     * 获取id
     * 
     * @return id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置id
     * 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取name
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取toolsUrl
     * 
     * @return toolsUrl
     */
    public String getToolsUrl() {
        return this.toolsUrl;
    }

    /**
     * 设置toolsUrl
     * 
     * @param toolsUrl
     */
    public void setToolsUrl(String toolsUrl) {
        this.toolsUrl = toolsUrl;
    }

    /**
     * 获取iconUrl
     * 
     * @return iconUrl
     */
    public String getIconUrl() {
        return this.iconUrl;
    }

    /**
     * 设置iconUrl
     * 
     * @param iconUrl
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * 获取toolTypeId
     * 
     * @return toolTypeId
     */
    public Integer getToolTypeId() {
        return this.toolTypeId;
    }

    /**
     * 设置toolTypeId
     * 
     * @param toolTypeId
     */
    public void setToolTypeId(Integer toolTypeId) {
        this.toolTypeId = toolTypeId;
    }
}
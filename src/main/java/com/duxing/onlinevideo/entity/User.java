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

import java.util.Date;

/**
 * USER
 * 
 * @author bianj
 * @version 1.0.0 2021-03-12
 */
public class User implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -681560957992239219L;

    /** id */
    private Integer id;

    /** mobile */
    private String mobile;

    /** username */
    private String username;

    /** password */
    private String password;

    /** email */
    private String email;

    /** vipFlag */
    private Integer vipFlag;

    /** createTime */
    private Date createTime;

    /** flag*/
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFalg(Integer flag) {
        this.flag = flag;
    }

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
     * 获取mobile
     * 
     * @return mobile
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * 设置mobile
     * 
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取username
     * 
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 设置username
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取password
     * 
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置password
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取email
     * 
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 设置email
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取vipFlag
     * 
     * @return vipFlag
     */
    public Integer getVipFlag() {
        return this.vipFlag;
    }

    /**
     * 设置vipFlag
     * 
     * @param vipFlag
     */
    public void setVipFlag(Integer vipFlag) {
        this.vipFlag = vipFlag;
    }

    /**
     * 获取createTime
     * 
     * @return createTime
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置createTime
     * 
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
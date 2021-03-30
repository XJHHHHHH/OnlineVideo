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
 * COURSE_TOPICS
 * 
 * @author bianj
 * @version 1.0.0 2021-03-12
 */
public class CourseTopics implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1185356640734747575L;

    /** id */
    private Integer id;

    /** titile */
    private String titile;

    /** iconUrl */
    private String iconUrl;

    /** topicIntro */
    private String topicIntro;

    /** topicUrl */
    private String topicUrl;

    /** views */
    private Integer views;

    /** flag */
    private Integer flag;

    /** typeId */
    private Integer typeId;

    /** vipFlag */
    private Integer vipFlag;

    /** coursewareUrl */
    private String coursewareUrl;

    /** createTime */
    private String createTime;

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
     * 获取titile
     * 
     * @return titile
     */
    public String getTitile() {
        return this.titile;
    }

    /**
     * 设置titile
     * 
     * @param titile
     */
    public void setTitile(String titile) {
        this.titile = titile;
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
     * 获取topicIntro
     * 
     * @return topicIntro
     */
    public String getTopicIntro() {
        return this.topicIntro;
    }

    /**
     * 设置topicIntro
     * 
     * @param topicIntro
     */
    public void setTopicIntro(String topicIntro) {
        this.topicIntro = topicIntro;
    }

    /**
     * 获取topicUrl
     * 
     * @return topicUrl
     */
    public String getTopicUrl() {
        return this.topicUrl;
    }

    /**
     * 设置topicUrl
     * 
     * @param topicUrl
     */
    public void setTopicUrl(String topicUrl) {
        this.topicUrl = topicUrl;
    }

    /**
     * 获取views
     * 
     * @return views
     */
    public Integer getViews() {
        return this.views;
    }

    /**
     * 设置views
     * 
     * @param views
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * 获取flag
     * 
     * @return flag
     */
    public Integer getFlag() {
        return this.flag;
    }

    /**
     * 设置flag
     * 
     * @param flag
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /**
     * 获取typeId
     * 
     * @return typeId
     */
    public Integer getTypeId() {
        return this.typeId;
    }

    /**
     * 设置typeId
     * 
     * @param typeId
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
     * 获取coursewareUrl
     * 
     * @return coursewareUrl
     */
    public String getCoursewareUrl() {
        return this.coursewareUrl;
    }

    /**
     * 设置coursewareUrl
     * 
     * @param coursewareUrl
     */
    public void setCoursewareUrl(String coursewareUrl) {
        this.coursewareUrl = coursewareUrl;
    }

    /**
     * 获取createTime
     * 
     * @return createTime
     */
    public String getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置createTime
     * 
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
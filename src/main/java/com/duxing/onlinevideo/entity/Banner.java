package com.duxing.onlinevideo.entity;

import java.util.Date;

/**
 * banner
 * 
 * @author bianj
 * @version 1.0.0 2020-09-16
 */
public class Banner implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 608131098407480109L;

    /* This code was generated by TableGo tools, mark 1 begin. */

    /** id */
    private Integer id;

    /** imgUrl */
    private String imgUrl;

    /** flag */
    private Integer flag;

    /** 广告图类型标识 */
    private Integer type;

    /** targetUrl */
    private String targetUrl;

    /** createTime */
    private Date createTime;

    /* This code was generated by TableGo tools, mark 1 end. */

    /* This code was generated by TableGo tools, mark 2 begin. */

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
     * 获取imgUrl
     * 
     * @return imgUrl
     */
    public String getImgUrl() {
        return this.imgUrl;
    }

    /**
     * 设置imgUrl
     * 
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
     * 获取广告图类型标识
     * 
     * @return 广告图类型标识
     */
    public Integer getType() {
        return this.type;
    }

    /**
     * 设置广告图类型标识
     * 
     * @param type
     *          广告图类型标识
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取targetUrl
     * 
     * @return targetUrl
     */
    public String getTargetUrl() {
        return this.targetUrl;
    }

    /**
     * 设置targetUrl
     * 
     * @param targetUrl
     */
    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
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

    /* This code was generated by TableGo tools, mark 2 end. */
}
package com.bootdo.sys.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title: MenuDO</p>
 * <p>Description: 菜单管理 DO</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public class MenuDO implements Serializable {

    private Long id;
    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单URL
     */
    private String url;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;
    /**
     * 类型 0：目录 1：菜单 2：按钮
     */
    private Integer type;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "MenuDO{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", perms='" + perms + '\'' +
                ", type=" + type +
                ", icon='" + icon + '\'' +
                ", orderNum=" + orderNum +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}

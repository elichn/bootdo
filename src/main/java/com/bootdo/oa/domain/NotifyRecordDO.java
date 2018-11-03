package com.bootdo.oa.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>Title: NotifyRecordDO</p>
 * <p>Description: 通知通告发送记录 DO</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public class NotifyRecordDO implements Serializable {

    private Long id;
    /**
     * 通知通告ID
     */
    private Long notifyId;
    /**
     * 接受人
     */
    private Long userId;
    /**
     * 阅读标记
     */
    private Integer isRead;
    /**
     * 阅读时间
     */
    private Date readDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNotifyId(Long notifyId) {
        this.notifyId = notifyId;
    }

    public Long getNotifyId() {
        return notifyId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public Date getReadDate() {
        return readDate;
    }

    @Override
    public String toString() {
        return "NotifyRecordDO{" +
                "id=" + id +
                ", notifyId=" + notifyId +
                ", userId=" + userId +
                ", isRead=" + isRead +
                ", readDate=" + readDate +
                '}';
    }
}

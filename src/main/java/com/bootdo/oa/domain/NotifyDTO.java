package com.bootdo.oa.domain;

/**
 * <p>Title: NotifyDTO</p>
 * <p>Description: 通知通告 DTO</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public class NotifyDTO extends NotifyDO {

    private String isRead;

    private String before;

    private String sender;

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "NotifyDTO{" +
                "isRead='" + isRead + '\'' +
                ", before='" + before + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}

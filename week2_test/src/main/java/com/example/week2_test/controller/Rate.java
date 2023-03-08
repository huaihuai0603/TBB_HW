package com.example.week2_test.controller;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//這個負責資料收集與提取
@Entity
@Table(name = "CRNC_RATE")
public class Rate {
    @Id
    @Column(name = "CRNC_ID")
    private String crncId;

    @Column(name = "BUY_RATE")
    private Float buyRate;

    @Column(name = "SELL_RATE")
    private Float sellRate;

    @Column(name = "BOOK_RATE")
    private Float bookRate;

    @Column(name = "MESSAGE_CODE")
    private String messageCode;

    @Column(name = "DOT")
    private String dot;

    @Column(name = "UPDATE_USER")
    private String updateUser;

    @Column(name = "UPDATE_TIME")
    private String updateTime;

    public String getCrncId() {
        return crncId;
    }

    public void setCrncId(String crncId) {
        this.crncId = crncId;
    }

    public Float getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(Float buyRate) {
        this.buyRate = buyRate;
    }

    public Float getSellRate() {
        return sellRate;
    }

    public void setSellRate(Float sellRate) {
        this.sellRate = sellRate;
    }

    public Float getBookRate() {
        return bookRate;
    }

    public void setBookRate(Float bookRate) {
        this.bookRate = bookRate;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getDot() {
        return dot;
    }

    public void setDot(String dot) {
        this.dot = dot;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
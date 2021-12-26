package cn.mafangui.hotel.entity;

import java.util.Date;

public class RoomType {
    private Integer typeId;

    private String roomType;

    private String remark;

    private Double price;

    private Double discount;

    private Integer area;

    private Integer bedNum;

    private String personNumber;

    private Integer window;

    private Integer rest;
    private String urlq;

    public String getUrlq() {
        return urlq;
    }

    public void setUrlq(String urlq) {
        this.urlq = urlq;
    }

    public Integer getRest() {
        return rest;
    }

    public void setRest(Integer rest) {
        this.rest = rest;
    }

    private Date createTime;

    private Date updateTime;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getBedNum() {
        return bedNum;
    }

    public void setBedNum(Integer bedNum) {
        this.bedNum = bedNum;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber == null ? null : personNumber.trim();
    }

    public Integer getWindow() {
        return window;
    }

    public void setWindow(Integer window) {
        this.window = window;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public RoomType() {
        this.rest = 0;
    }

    public RoomType(String roomType, String remark, Double price, Double discount, Integer area, Integer bedNum, String personNumber, Integer window,String urlq) {
        this.roomType = roomType;
        this.remark = remark;
        this.price = price;
        this.discount = discount;
        this.area = area;
        this.bedNum = bedNum;
        this.personNumber = personNumber;
        this.window = window;
        this.urlq=urlq;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "typeId=" + typeId +
                ", roomType='" + roomType + '\'' +
                ", remark='" + remark + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", area=" + area +
                ", bedNum=" + bedNum +
                ", bedSize='" + personNumber + '\'' +
                ", window=" + window +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", urlq=" + urlq +
                '}';
    }
}

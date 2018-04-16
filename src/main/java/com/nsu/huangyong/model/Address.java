package com.nsu.huangyong.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 会员编号
     */
    private String memberNo;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    /**
     * 详细地址
     */
    private String addressDetailed;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 收货人姓名
     */
    private String receiveName;
    /**
     * 收货人电话
     */
    private String phone;

    public Address(String memberNo, String province, String city, String district, String street, String addressDetailed, String createTime, Integer status, String receiveName, String phone) {
        this.memberNo = memberNo;
        this.province = province;
        this.city = city;
        this.district = district;
        this.street = street;
        this.addressDetailed = addressDetailed;
        this.createTime = createTime;
        this.status = status;
        this.receiveName = receiveName;
        this.phone = phone;
    }
}

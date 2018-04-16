package com.nsu.huangyong.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Goods {
    /**
     * id
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 商品编号
     */
    private String goodsNo;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 卖家编号
     */
    private String sellerNo;
    /**
     * 标题
     */
    private String title;
    /**
     * 价格
     */
    private String goodsPrice;
    /**
     * 品牌
     */
    private String brand;
    /**
     * 包装
     */
    private String pack;
    /**
     * 原产地
     */
    private String productCity;
    /**
     * 类别
     */
    private String category;
    /**
     * 果实直径
     */
    private String diameter;
    /**
     * 活动编号
     */
    private String activityNo;
    /**
     * 介绍图片地址
     */
    private String introduce;
    /**
     * 状态（0：初始 1：上架 2：下架）
     */
    private Integer status;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 图片1
     */
    @Column(name = "pic1_url")
    private String pic1Url;
    @Column(name = "pic2_url")
    private String pic2Url;
    @Column(name = "pic3_url")
    private String pic3Url;
    @Column(name = "pic4_url")
    private String pic4Url;
    @Column(name = "pic5_url")
    private String pic5Url;

}

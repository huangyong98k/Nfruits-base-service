package com.nsu.huangyong.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Huang-Yong on 2018/4/26
 */
@NoArgsConstructor
@Entity
@Data
@Table(name = "bankcard")
public class BankCard {
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 会员编号
     */
    private String memberNo;
    /**
     * 卡运营商
     */
    private String cardOperator;
    /**
     * 绑定手机号
     */
    private String phoneNo;
    /**
     * 真实姓名
     */
    private String trueName;
    /**
     * 卡类型
     */
    private String cardType;
    /**
     * 卡状态（1：可用 2：失效）
     */
    private String status;

    public BankCard(String cardNo, String memberNo, String cardOperator, String phoneNo, String trueName, String cardType) {
        this.cardNo = cardNo;
        this.memberNo = memberNo;
        this.cardOperator = cardOperator;
        this.phoneNo = phoneNo;
        this.trueName = trueName;
        this.cardType = cardType;
    }
}

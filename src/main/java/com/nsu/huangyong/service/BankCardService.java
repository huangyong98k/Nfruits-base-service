package com.nsu.huangyong.service;

import com.nsu.huangyong.pojo.BankCard;
import com.nsu.huangyong.vo.CommonResp;

import java.util.List;

/**
 * Created by Huang-Yong on 2018/4/26
 */
public interface BankCardService {
        /**
         * 新增银行卡
         */
        CommonResp addBankCard(String memberNo, String cardNo, String cardOperator, String phoneNo, String trueName, String cardType);
        /**
         * 查看银行卡
         */
        List<BankCard> availableBankCard(String memberNo);
        /**
         * 银行卡失效
         */
        CommonResp bankCardInvalid(String bankCardId);
}

package com.nsu.huangyong.service.impl;

import com.nsu.huangyong.common.constant.CommonRespCode;
import com.nsu.huangyong.dao.BankCardDao;
import com.nsu.huangyong.pojo.BankCard;
import com.nsu.huangyong.service.BankCardService;
import com.nsu.huangyong.vo.CommonResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Huang-Yong on 2018/4/26
 */
@Service
@Slf4j
public class BankCardServiceImpl implements BankCardService {
        @Autowired
        private BankCardDao bankCardDao;
        @Override
        public CommonResp addBankCard(String memberNo, String cardNo, String cardOperator, String phoneNo, String trueName, String cardType) {
                BankCard bankCard = new BankCard(cardNo, memberNo, cardOperator, phoneNo, trueName, cardType);
                try {
                        bankCardDao.save(bankCard);
                        log.info("Add bankCard success !!!");
                        return new CommonResp(CommonRespCode.SUCCESS);
                }catch (Exception e){
                        log.error("Add bankCard error :{}:{}",e.getClass(),e.getMessage());
                        return new CommonResp(CommonRespCode.FAIL,"服务异常");
                }
        }

        @Override
        public List<BankCard> availableBankCard(String memberNo) {
                return bankCardDao.findAvailableBankCard(memberNo, "1");
        }

        @Override
        @Transactional
        public CommonResp bankCardInvalid(String bankCardId) {
                try {
                        bankCardDao.bankCardInvalid(bankCardId,"2");
                        log.info("Invalid bankCard success !!!");
                        return new CommonResp(CommonRespCode.SUCCESS);
                } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Invalid bankCard error :{}:{}",e.getClass(),e.getMessage());
                        return new CommonResp(CommonRespCode.FAIL,"服务异常");
                }

        }
}

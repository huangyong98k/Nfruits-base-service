package com.nsu.huangyong.dao;

import com.nsu.huangyong.pojo.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Huang-Yong on 2018/4/26
 */
public interface BankCardDao extends JpaRepository<BankCard,Long>{
    /**
     * Desc: 获取可用的银行卡
     */
    @Query(value = "select * from bankcard where member_no=?1 and status=?2",nativeQuery = true)
    @Modifying
    List<BankCard> findAvailableBankCard(String memberNo, String status);
    /**
     * 将银行卡改为不可用状态
     */
    @Query(value = "update bankcard set status = ?2 where id = ?1",nativeQuery = true)
    @Modifying
    void bankCardInvalid(String bankCardId,String status);
}

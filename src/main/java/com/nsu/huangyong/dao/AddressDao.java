package com.nsu.huangyong.dao;

import com.nsu.huangyong.pojo.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressDao extends JpaRepository<Address,Long>,JpaSpecificationExecutor<Address>{
    /**
     * 修改收货地址
     */
    @Query(value = "update address set province = ?2,city = ?3,district = ?4,street=?5,address_detailed=?6,receive_name=?7,phone=?8 where id =?1",nativeQuery = true)
    @Modifying
    void updateAddress(String addressId,String province,String city,String district,String street,String addressDetailed,String receiveName, String phone);

    /**
     * 查询可用收货地址
     */
    @Query(value = "select * from address where member_no=?1 and status=?2",nativeQuery = true)
    @Modifying
    List<Address> findAvailableAddressByMemberNo(String memberNo,Integer status);

    /**
     * 将地址改为不可用状态
     */
    @Query(value = "update address set status = ?2 where id = ?1",nativeQuery = true)
    @Modifying
    void addressInvalid(String addressId,Integer status);
}

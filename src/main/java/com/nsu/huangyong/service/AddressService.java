package com.nsu.huangyong.service;

import com.nsu.huangyong.model.Address;
import com.nsu.huangyong.vo.CommonResp;

import java.util.List;

/**
 * DESC:
 * @author Huang-Yong create on 2018-04-12
 */
public interface AddressService {
    /**
     * 新增收货地址
     */
    CommonResp addAddress(String memberNo,String province,String city,String district,String street,String addressDetailed,String receiveName, String phone);
    /**
     * 修改收货地址
     */
    CommonResp modifyAddress(String addressId,String province,String city,String district,String street,String addressDetailed,String receiveName, String phone);
    /**
     * 查看可用地址
     */
    List<Address> availableAddress(String memberNo);
    /**
     * 地址失效
     */
    CommonResp addressInvalid(String addressId);


}

package com.nsu.huangyong.service.impl;

import com.nsu.huangyong.common.constant.AddressStatus;
import com.nsu.huangyong.common.constant.CommonRespCode;
import com.nsu.huangyong.common.utils.NFruitsUtils;
import com.nsu.huangyong.dao.AddressDao;
import com.nsu.huangyong.pojo.Address;
import com.nsu.huangyong.service.AddressService;
import com.nsu.huangyong.vo.CommonResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Override
    public CommonResp addAddress(String memberNo,String province, String city, String district, String street, String addressDetailed, String receiveName, String phone) {
        Address address = new Address(memberNo,province,city,district,street,addressDetailed,NFruitsUtils.getCurrentTime(), AddressStatus.AVAILABLE.getValue(),receiveName,phone);
        try {
            addressDao.save(address);
            log.info("Add address success !!!");
            return new CommonResp(CommonRespCode.SUCCESS);
        }catch (Exception e){
            log.debug("Add address error !",e);
            return new CommonResp(CommonRespCode.FAIL,"服务异常");
        }
    }

    @Override
    @Transactional
    public CommonResp modifyAddress(String addressId, String province, String city, String district, String street, String addressDetailed, String receiveName, String phone) {
        try {
            addressDao.updateAddress(addressId,province,city,district,street,addressDetailed,receiveName,phone);
            log.info("Update address success !");
            return new CommonResp(CommonRespCode.SUCCESS);
        }catch (Exception e){
            log.debug("update address error ! ",e);
            return new CommonResp(CommonRespCode.FAIL,"数据异常");
        }
    }

    @Override
    public List<Address> availableAddress(String memberNo) {
        return addressDao.findAvailableAddressByMemberNo(memberNo,AddressStatus.AVAILABLE.getValue());
    }

    @Override
    @Transactional
    public CommonResp addressInvalid(String addressId) {
        try {
            addressDao.addressInvalid(addressId,AddressStatus.NO_AVAILABLE.getValue());
            log.info("update adderss status success,addressId: {}",addressId);
            return new CommonResp(CommonRespCode.SUCCESS);
        }
        catch (Exception e){
            log.debug("update adderss status error {}",e);
            return new CommonResp(CommonRespCode.FAIL,"Address incalid faile !!!");
        }
    }
}

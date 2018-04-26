package com.nsu.huangyong.web;

import com.nsu.huangyong.common.constant.CommonRespCode;
import com.nsu.huangyong.common.utils.JSONUtils;
import com.nsu.huangyong.pojo.Address;
import com.nsu.huangyong.service.AddressService;
import com.nsu.huangyong.vo.CommonResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@Api(value = "API-base-service",description = "收货地址管理")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @ApiOperation(value ="新增收货地址" )
    @GetMapping("/address/add")
    public CommonResp addAddress(@RequestParam("memberNo") String memberNo,
                                 @RequestParam("province")String province,
                                 @RequestParam("city")String city,
                                 @RequestParam("district")String district,
                                 @RequestParam("street")String street,
                                 @RequestParam("addressDetailed")String addressDetailed,
                                 @RequestParam("receiveName")String receiveName,
                                 @RequestParam("phone")String phone){
        log.info("recevie message: {},{},{},{},{},{},{},{}",memberNo,province,city,district,street,addressDetailed,receiveName,phone);
        return addressService.addAddress(memberNo,province,city,district,street,addressDetailed,receiveName,phone);
    }

    @ApiOperation(value ="修改收货地址" )
    @GetMapping("/address/modify")
    public CommonResp modifyAddress(@RequestParam("addressId") String addressId,
                                    @RequestParam("province")String province,
                                    @RequestParam("city")String city,
                                    @RequestParam("district")String district,
                                    @RequestParam("street")String street,
                                    @RequestParam("addressDetailed")String addressDetailed,
                                    @RequestParam("receiveName")String receiveName,
                                    @RequestParam("phone")String phone){
        log.info("recevie message: {},{},{},{},{},{},{},{}",addressId,province,city,district,street,addressDetailed,receiveName,phone);
        return addressService.modifyAddress(addressId,province,city,district,street,addressDetailed,receiveName,phone);
    }

    @ApiOperation(value ="根据会员编号查看可用地址" )
    @GetMapping("/address/available")
    public String queryAvailableAddress(@RequestParam("memberNo") String memberNo){
        log.info("recevie message: {}",memberNo);
        List<Address> list =  addressService.availableAddress(memberNo);
        if (list.isEmpty()){
            return JSONUtils.toJsonAndIgnoreException(new CommonResp(CommonRespCode.FAIL,"no data !!!"));
        }else {
            return JSONUtils.toJsonAndIgnoreException(list);
        }
    }

    @ApiOperation(value ="根据收货地址Id使地址失效" )
    @GetMapping("/address/invalid")
    public CommonResp addressInvalid(@RequestParam("addressId") String addressId){
        log.info("recevie message: {}",addressId);
        return addressService.addressInvalid(addressId);
    }
}

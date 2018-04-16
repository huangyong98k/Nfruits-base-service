package com.nsu.huangyong.web;

import com.nsu.huangyong.common.constant.CommonRespCode;
import com.nsu.huangyong.common.utils.JSONUtils;
import com.nsu.huangyong.model.Goods;
import com.nsu.huangyong.service.GoodsService;
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
@RequestMapping("/api/goods")
@Api(value = "API-base-service",description = "商品基础业务支撑服务")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value ="动态查询" )
    @GetMapping("/findgoods")
    public String getGoodsByPage(@RequestParam(value = "goodsName",required = false) String goodsName,
                                 @RequestParam(value = "goodsPrice",required = false) String goodsPrice,
                                 @RequestParam(value = "brand",required = false) String brand,
                                 @RequestParam(value = "category",required = false) String category,
                                 @RequestParam(value = "pageId",required = false) Integer pageId,
                                 @RequestParam(value = "numberAmount",required = false) Integer numberAmount){
        List<Goods> list =goodsService.getAllByPage(goodsName,goodsPrice,brand,category,pageId,numberAmount);
        if(pageId == null || numberAmount == null){
            return String.valueOf(list.size());
        }else {
            return JSONUtils.toJsonAndIgnoreException(list);
        }
    }
}

package com.nsu.huangyong.service;

import com.nsu.huangyong.model.Goods;

import java.util.List;

/**
 * 基础商品服务
 */
public interface GoodsService {
    /**
     * 商品动态查询
     */
    List<Goods> getAllByPage(String goodsName, String goodsPrice, String brand, String category,Integer pageId,Integer numberAmount);
}

package com.nsu.huangyong.service.impl;

import com.nsu.huangyong.dao.GoodsDao;
import com.nsu.huangyong.model.Goods;
import com.nsu.huangyong.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品服务实现类
 * @author huangyong.nsu@qq.com
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> getAllByPage(String goodsName, String goodsPrice, String brand, String category, Integer pageId, Integer numberAmount) {
        List<Goods> list = new ArrayList<>();
        Specification<Goods> specification = where(goodsName,goodsPrice,brand,category);
        if (pageId == null || numberAmount == null){
            list = goodsDao.findAll(specification);
        }else {
            Pageable pageable = new PageRequest(pageId-1,numberAmount, Sort.Direction.DESC,"id");
            Page<Goods> page = goodsDao.findAll(specification,pageable);
            if(!page.getContent().isEmpty()){
                for (Goods goods:page.getContent()) {
                    list.add(goods);
                }
                log.info("query goods success");
            }else {
                list.add(new Goods());
                log.info("not found record");
            }
        }
        return list;
    }

    /**
     * 条件查询时动态组装条件
     */
    private Specification<Goods> where(final String goodsName, final String goodsPrice, final String brand, final String category) {
        return (Root<Goods> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            //商品名称
            if(goodsName != null && !"".equals(goodsName)){
                predicates.add(root.<String>get("goodsName").in(goodsName));
            }
            //商品价格
            if(goodsPrice != null && !"".equals(goodsPrice)){
                predicates.add(root.<String>get("goodsPrice").in(goodsPrice));
            }
            //品牌
            if(brand != null && !"".equals(brand)){
                predicates.add(root.<String>get("brand").in(brand));
            }
            //类别
            if(category != null && !"".equals(category)){
                predicates.add(root.<String>get("category").in(category));
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };
    }
}

package com.nsu.huangyong.dao;

import com.nsu.huangyong.model.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GoodsDao extends JpaRepository<Goods,Long>, JpaSpecificationExecutor<Goods> {
    /**
     * 根据状态获取商品
     */
    List<Goods> findAllByStatus(int status);

    @Override
    Page<Goods> findAll(Specification<Goods> specification, Pageable pageable);

    @Override
    List<Goods> findAll(Specification<Goods> specification);
}

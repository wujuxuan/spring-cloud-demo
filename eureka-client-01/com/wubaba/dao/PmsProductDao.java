package com.wubaba.dao;

import lombok.extern.slf4j.Slf4j;
import com.wubaba.entity.PmsProduct;
import com.wubaba.mapper.PmsProductMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * 商品表(pms_product)数据DAO
 *
 * @author kancy
 * @since 2021-05-25 19:24:42
 * @description 由 Mybatisplus Code Generator 创建
 */
@Slf4j
@Repository
public class PmsProductDao extends ServiceImpl<PmsProductMapper, PmsProduct> {

}
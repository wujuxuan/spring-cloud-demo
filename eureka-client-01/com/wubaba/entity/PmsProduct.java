package com.wubaba.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 商品表(pms_product)实体类
 *
 * @author kancy
 * @since 2021-05-25 19:24:42
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_product")
public class PmsProduct extends Model<PmsProduct> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
	private Long id;
    /**
     * 商品名称
     */
    private String title;
    /**
     * 副标题
     */
    private String subtitle;
    /**
     * 分类id--取二级分类id
     */
    private Long sortId;
    /**
     * 品牌Id
     */
    private Long brandId;
    /**
     * 运费模板ID
     */
    private Long freightId;
    /**
     * 商家id
     */
    private Long storeId;
    /**
     * 税费
     */
    private BigDecimal taxation;
    /**
     * 标签1
     */
    private String labelOne;
    /**
     * 标签2
     */
    private String labelTwo;
    /**
     * 标签3
     */
    private String labelThree;
    /**
     * 页签表id
     */
    private Long productTabId;
    /**
     * 商品主图
     */
    private String pic;
    /**
     * 商品轮播图（多张用逗号分开）
     */
    private String banner;
    /**
     * 商品视频
     */
    private Object video;
    /**
     * 商品详情
     */
    private Object details;
    /**
     * 商品价格（取sku的最低价格）
     */
    private BigDecimal price;
    /**
     * 总库存（sku库存总和）
     */
    private Integer stock;
    /**
     * 总销量（sku的销量总和）
     */
    private Integer sales;
    /**
     * 商品类型：1--普通商品；2--预售商品
     */
    private Integer productType;
    /**
     * 预售金额
     */
    private BigDecimal preSaleAmount;
    /**
     * 发售时间
     */
    private Date preSaleTime;
    /**
     * 状态：1--已上架；2--已下架；3--待审核；4--已驳回
     */
    private Integer status;
    /**
     * 删除状态：1--未删除；2--已删除
     */
    private Integer deleteStatus;
    /**
     * 编辑时间
     */
    private Date editTime;
    /**
     * 编辑人
     */
    private Long editId;
    /**
     * 驳回原因
     */
    private String rejectionReason;
    /**
     * 审核时间
     */
    private Date examineTime;
    /**
     * 审核人
     */
    private Long examineId;
    /**
     * 上架时间
     */
    private Date saleTime;
    /**
     * 下架时间
     */
    private Date underTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(update = "now()")
	private Date updateTime;
    /**
     * skuNameJson
     */
    private String skuNameJson;

}
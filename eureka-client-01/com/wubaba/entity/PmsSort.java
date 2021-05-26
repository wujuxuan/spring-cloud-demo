package com.wubaba.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 商品分类表(pms_sort)实体类
 *
 * @author kancy
 * @since 2021-05-25 19:24:43
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("pms_sort")
public class PmsSort extends Model<PmsSort> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
	private Long id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * APP图标
     */
    private String appPic;
    /**
     * 小程序图标
     */
    private String appletsPic;
    /**
     * 父类id
     */
    private Long parentId;
    /**
     * 级别：1--一级；2--二级
     */
    private Integer level;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 是否显示：1--不显示 2--显示
     */
    private Integer isShow;
    /**
     * 编辑时间
     */
    private Date editTime;
    /**
     * 编辑人id
     */
    private Long editId;
    /**
     * 状态：1--待审核；2-已通过；3--已驳回
     */
    private Integer status;
    /**
     * 驳回原因
     */
    private String rejectionReason;
    /**
     * 审核时间
     */
    private Date examineTime;
    /**
     * 审核人id
     */
    private Long examineId;
    /**
     * 店铺id
     */
    private Long storeId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(update = "now()")
	private Date updateTime;

}
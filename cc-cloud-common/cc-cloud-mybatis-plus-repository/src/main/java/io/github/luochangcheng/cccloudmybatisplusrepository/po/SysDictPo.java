package io.github.luochangcheng.cccloudmybatisplusrepository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 字典
 * </p>
 *
 * @author passion
 * @since 2024-11-13 11:54:43
 */
@Data
@Accessors(chain = true)
@TableName(value = "sys_dict", schema = "cc_cloud_extend")
public class SysDictPo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 字典类型编号
     */
    @TableField("type_code")
    private String typeCode;

    /**
     * 字典类型名称
     */
    @TableField("type_name")
    private String typeName;

    /**
     * 枚举编号
     */
    @TableField("code")
    private Integer code;

    /**
     * 枚举值
     */
    @TableField("value")
    private String value;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;


}

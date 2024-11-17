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
 * 管理端用户
 * </p>
 *
 * @author passion
 * @since 2024-11-15 16:25:57
 */
@Data
@Accessors(chain = true)
@TableName(value = "sys_admin_user", schema = "cc_cloud_user")
public class SysAdminUserPo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     *
     */
    @TableField("username")
    private String username;

    /**
     *
     */
    @TableField("password")
    private String password;


}

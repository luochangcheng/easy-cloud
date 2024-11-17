package io.github.luochangcheng.ccclouduser.http.req.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 字典 新增/修改请求体
 * </p>
 *
 * @author passion
 * @since 2024-11-13 11:54:46
 */
@Data
@Accessors(chain = true)
public class SysDictModifyReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    private String id;

    @Schema(description = "字典类型编号")
    private String typeCode;

    @Schema(description = "字典类型名称")
    private String typeName;

    @Schema(description = "枚举编号")
    private Integer code;

    @Schema(description = "枚举值")
    private String value;

    @Schema(description = "排序")
    private Integer sort;

}

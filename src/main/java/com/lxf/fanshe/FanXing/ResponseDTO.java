package com.lxf.fanshe.FanXing;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>用于各个服务数据传输统一响应结构</p>
 *
 * @author puchaobo@xfdsx.com
 * @date 2019-10-10
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ApiModel(description = "返回值实体")
public final class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = -8531884046266912382L;

    @ApiModelProperty(value = "响应码")
    private Integer code;

    @ApiModelProperty(value = "响应信息")
    private String message;

    @ApiModelProperty(value = "响应数据")
    private T data;

    /**
     * <p>返回信息实例工厂</p>
     *
     * @author puchaobo@xfdsx.com
     * @date 2020-03-07 17:11:56
     */
    public static final class Factory {

        public static <T> ResponseDTO<T> ok(final T data) {
            return ResponseDTO.<T>builder()
                    .code(20000)
                    .message("成功")
                    .data(data)
                    .build();
        }
    }
}

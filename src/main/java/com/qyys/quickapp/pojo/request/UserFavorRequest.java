package com.qyys.quickapp.pojo.request;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * @author : Yuan.Pan 2022/4/17 10:44 AM
 */
@Data
public class UserFavorRequest {

    @NotNull(message = "skuId 不能为空")
    private Long skuId;

    @NotNull(message = "是否收藏不能为空")
    private Boolean likeFlag;
}

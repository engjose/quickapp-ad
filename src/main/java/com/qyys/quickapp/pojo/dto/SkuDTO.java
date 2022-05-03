package com.qyys.quickapp.pojo.dto;

import com.qyys.quickapp.pojo.vo.SkuDetailVO;
import lombok.Data;

import java.util.List;

/**
 * @author : Yuan.Pan 2022/5/3 7:13 PM
 */
@Data
public class SkuDTO {
    private Long id;
    private String name;
    private Long menuId;
    private Integer score;
    private String desc;
    private String mainImg;
    private List<MaterialDTO> materials;
    private List<SkuDetailVO> details;
}

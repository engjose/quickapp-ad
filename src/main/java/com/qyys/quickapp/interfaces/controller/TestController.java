package com.qyys.quickapp.interfaces.controller;

import com.alibaba.fastjson.JSONArray;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.qyys.quickapp.pojo.dto.SkuDTO;
import com.qyys.quickapp.pojo.po.SkuPO;
import com.qyys.quickapp.pojo.response.BaseResponse;
import com.qyys.quickapp.pojo.vo.SkuMaterialVO;
import com.qyys.quickapp.repository.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : Yuan.Pan 2022/5/3 7:24 PM
 */
@Validated
@RestController
@RequestMapping("/quick-app/test")
public class TestController {

    @Autowired
    private SkuMapper skuMapper;

    @GetMapping("/init-sku")
    public BaseResponse<Void> init() throws IOException {
        String jsonData = Files.asCharSource(new File("/Users/panyuanyuan/Desktop/快应用/data/sku.json"), Charsets.UTF_8).read();

        List<SkuDTO> skuList = JSONArray.parseArray(jsonData, SkuDTO.class);

        List<SkuPO> skuPOList = new ArrayList<>();
        skuList.forEach(element -> {
            SkuPO record = new SkuPO();
            record.setMenuId(element.getMenuId());
            record.setSkuName(element.getName());
            record.setAddTime(new Date());
            record.setUpdateTime(new Date());
            record.setSkuScore(element.getScore());
            record.setSkuDesc(element.getDesc());
            record.setSkuImg(element.getMainImg());

            List<SkuMaterialVO> skuMaterialVOS = new ArrayList<>();
            element.getMaterials().forEach(materialDTO -> {
                SkuMaterialVO skuMaterialVO = new SkuMaterialVO();
                skuMaterialVO.setName(materialDTO.getName());
                skuMaterialVO.setValue(materialDTO.getAmount());
                skuMaterialVOS.add(skuMaterialVO);
            });
            record.setMaterial(JSONArray.toJSONString(skuMaterialVOS));
            record.setDetail(JSONArray.toJSONString(element.getDetails()));
            skuPOList.add(record);
        });

        skuPOList.forEach(skuPO -> skuMapper.insertSelective(skuPO));
        return BaseResponse.SUCCESS();
    }
}

package com.qyys.quickapp.pojo.request;

import lombok.Data;

/**
 * @author : Yuan.Pan 2022/4/16 4:09 PM
 */
@Data
public class PageQueryRequest {
    /** 页码 */
    private int pageNum = 1;

    /** 每页的数量 */
    private int pageSize = 10;
}

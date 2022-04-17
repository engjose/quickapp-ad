package com.qyys.quickapp.pojo.response;
import lombok.Data;
import java.util.List;

/**
 * @author : Yuan.Pan 2022/4/16 4:13 PM
 */
@Data
public class PageQueryResponse<T> {

    /** 总数 */
    private long total = 0;

    /** 数据列表 */
    private List<T> list;

    public PageQueryResponse(long total, List<T> list) {
        this.total = total;
        this.list = list;
    }
}

package com.dumplingbao.message.core;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页
 * Created by TJ on 2018/8/14.
 */
@Data
@Slf4j
public class Page implements Serializable {

    // 显示第几页 默认从第一页开始
    @Transient
    @JSONField(serialize = false)
    private int page = 1;

    // 每页10行
    @Transient
    @JSONField(serialize = false)
    private int rows = 10;

    // 排序字段
    @Transient
    @JSONField(serialize = false)
    private String[] sorts;

    // 升序或者降序 跟sort元素一一对应
    @Transient
    @JSONField(serialize = false)
    private String[] orders;


    /**
     * 单个排序字段 field_order 例如 "facilitatorName_ascend" "messageType_descend"
     * 加该字段主要为了迎合antDesign的前端开发
     */
    @Transient
    @JSONField(serialize = false)
    private String sorter;

    public void setRows(int rows) {
        if (rows <= 0) {
            rows = 10;
        }
        this.rows = rows;
    }

    /**
     * 拼接排序及分页查询条件
     * @param query
     * @return
     */
    public Query getPageQuery(Query query) {
        if (sorts != null && sorts.length > 0 && orders != null && orders.length > 0 && sorts.length == orders.length) {
            Sort.Order[] sortOrders = new Sort.Order[sorts.length];
            for (int i = 0; i < sorts.length; i++) {
                String fieldName = sorts[i];
                String orderName = orders[i];
                sortOrders[i] = new Sort.Order(Sort.Direction.fromString(orderName), fieldName);
            }
            query = query.with(new Sort(sortOrders));
        }
        return query.skip((getPage() - 1) * getRows()).limit(getRows());
    }

    /**
     * 连表查询时候用到的排序组件
     * @return
     */
    public List<SortOperation> fetchSortOperationList() {
        List<SortOperation> sortOperationList = new ArrayList<>();
        if (ArrayUtils.isNotEmpty(sorts) && ArrayUtils.isNotEmpty(orders) && sorts.length == orders.length) {
            for (int i = 0; i < sorts.length; i++) {
                String fieldName = sorts[i];
                String orderName = orders[i];
                sortOperationList.add(Aggregation.sort(new Sort(Sort.Direction.fromString(orderName), fieldName)));
            }
        } else {
            log.error("排序设置的条件不生效，sorts is {}, orders is {}", StringUtils.join(sorts, ","), StringUtils.join(orders, ","));
        }
        return sortOperationList;
    }
}

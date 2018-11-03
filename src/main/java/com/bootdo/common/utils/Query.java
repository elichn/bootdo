package com.bootdo.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * <p>Title: Query</p>
 * <p>Description: 查询参数</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public class Query extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 1L;
    private int offset;
    /**
     * 每页条数
     */
    private int limit;

    public Query(Map<String, Object> params) {
        this.putAll(params);
        // 分页参数
        this.offset = Integer.parseInt(params.get("offset").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("offset", offset);
        this.put("page", offset / limit + 1);
        this.put("limit", limit);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.put("offset", offset);
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}

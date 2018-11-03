package com.bootdo.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: PageUtils</p>
 * <p>Description: PageUtils</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public class PageUtils implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int total;
    private List<?> rows;

    public PageUtils(List<?> list, int total) {
        this.rows = list;
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

}

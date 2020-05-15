package com.hqu.community.entity;

public class Page {
    //当前页码
    private int current = 1;
    //显示单页上限
    private int limit = 10;
    //数据总数
    private int rows;
    //查询路径（用于复用分页链接）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    /**
     * 获得当前页第一条数据在查询中的位置
     * @return int
     */
    public int getOffset() {
        return (current - 1) * limit;
    }

    /**
     * 总共要显示多少页
     * @return int
     */
    public int getTotal() {
        if(rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * 当前页的起始页码
     * @return int
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }

}

package com.madhoue.dsp.uadata.models.common;

import java.util.ArrayList;
import java.util.List;

/**
 * List分页
 * 实现：利用List的获取子List方法，实现对List的分页
 */
public class PageModel<T> implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private int pageRecorders;// 每页5条数据

    private int page = 1; // 当前页

    public int totalPages = 0; // 总页数

    private int totalRows = 0; // 总数据数

    private int pageStartRow = 0;// 每页的起始数

    private int pageEndRow = 0; // 每页显示数据的终止数

    private List list;


    public int getPageRecorders() {
        return pageRecorders;
    }

    public void setPageRecorders(int pageRecorders) {
        this.pageRecorders = pageRecorders;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPageStartRow() {
        return pageStartRow;
    }

    public void setPageStartRow(int pageStartRow) {
        this.pageStartRow = pageStartRow;
    }

    public int getPageEndRow() {
        return pageEndRow;
    }

    public void setPageEndRow(int pageEndRow) {
        this.pageEndRow = pageEndRow;
    }

    public List getList() {
        return list == null ? new ArrayList() : list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public PageModel(List list, int pageRecorders) {
        init(list, pageRecorders);// 通过对象集，记录总数划分
    }

    public PageModel(){}

    /**
     * 初始化list，并告之该list每页的记录数
     * @param list
     * @param pageRecorders
     */
    public void init(List list, int pageRecorders) {
        this.pageRecorders = pageRecorders;
        this.list = list;
        totalRows = list.size();
        if ((totalRows % pageRecorders) == 0) {
            totalPages = totalRows / pageRecorders;
        } else {
            totalPages = totalRows / pageRecorders + 1;
        }

        if (totalRows < pageRecorders) {
            this.pageStartRow = 0;
            this.pageEndRow = totalRows;
        } else {
            this.pageStartRow = 0;
            this.pageEndRow = pageRecorders;
        }
    }

    /**
     * 获取第几页的内容
     * @param page
     * @return
     */
    public List getObjects(int page) {
        if (page == 0)
            this.setPage(1);
        else
            this.setPage(page);
        if (page * pageRecorders < totalRows) {// 判断是否为最后一页
            pageEndRow = page * pageRecorders;
            pageStartRow = pageEndRow - pageRecorders;
        } else {
            pageEndRow = totalRows;
            pageStartRow = pageRecorders * (totalPages - 1);
        }

        List objects = null;
        if (!list.isEmpty()) {
            objects = list.subList(pageStartRow, pageEndRow);
        }
        return objects;
    }


}

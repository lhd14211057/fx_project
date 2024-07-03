package com.fffx.project.common;


import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页查询需要，比如只展示第1-20条数据
 * @param <T>
 */
@Data
@ApiModel(description = "分页查询统一返回")
public class PagingResult<T> {

    @ApiModelProperty(name = "data", value = "分页查询列表数据")
    private List<T> items = new ArrayList<>();

    @ApiModelProperty(name = "cn", value = "当前页数", allowableValues = "range[1, infinity]")
    private Integer cn;

    @ApiModelProperty(name = "sn", value = "分页阈值", allowableValues = "range[1, infinity]")
    private Integer sn;

    @ApiModelProperty(name = "tn", value = "总条数", allowableValues = "range[1, infinity]")
    private Long tn = 0l;

    public PagingResult() {

    }

    public PagingResult(Integer cn, Integer sn) {
        this.cn = cn;
        this.sn = sn;
    }

    public PagingResult empty() {
        this.items = new ArrayList();
        this.tn = 0l;
        return this;
    }

    public void updatePaging(Page page) {
        if (page == null) return;
        cn = page.getPageNum();
        sn = page.getPageSize();
        tn = page.getTotal();
    }

    public void copyNum(PagingResult pagingResult) {
        if (pagingResult == null) return;
        cn = pagingResult.getCn();
        sn = pagingResult.getSn();
        tn = pagingResult.getTn();
    }
}

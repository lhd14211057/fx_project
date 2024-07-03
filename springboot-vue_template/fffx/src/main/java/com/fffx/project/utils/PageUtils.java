package com.fffx.project.utils;

import com.fffx.project.common.PagingResult;
import com.google.common.base.Preconditions;

/**
 * 前端分页参数校验工具类
 */
public class PageUtils {

    private static final int DEFAULT_PAGE_COUNT = 10;

    public static void checkAndSetPageInfo(PagingResult<?> pagingResult) {
        Preconditions.checkArgument(pagingResult != null, "参数异常");
        Integer pageNum = pagingResult.getCn();
        Integer pageSize = pagingResult.getSn();
        if (pageNum == null || pageNum < 1) pagingResult.setCn(1);
        if (pageSize == null || pageSize < 1) pagingResult.setSn(DEFAULT_PAGE_COUNT);
    }
}


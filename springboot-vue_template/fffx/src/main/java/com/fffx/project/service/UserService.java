package com.fffx.project.service;

import com.fffx.project.common.PagingResult;
import com.fffx.project.vo.UserVo;

public interface UserService {
    PagingResult<UserVo> list(PagingResult<UserVo> pagingResult);
}

package com.fffx.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fffx.project.common.PagingResult;
import com.fffx.project.entity.User;
import com.fffx.project.entity.UserExample;
import com.fffx.project.mapper.UserMapper;
import com.fffx.project.service.UserService;
import com.fffx.project.utils.PageUtils;
import com.fffx.project.vo.UserVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 具体怎么处理数据都写在service里，保持controller整洁
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public PagingResult<UserVo> list(PagingResult<UserVo> pagingResult) {
        //参数校验
        PageUtils.checkAndSetPageInfo(pagingResult);

        //数据库操作，用example添加where条件，很方便，可以百度一下
        UserExample userExample = new UserExample();
//        userExample.createCriteria().andIdBetween(1, 10);

        PageHelper.startPage(pagingResult.getCn(), pagingResult.getSn(), "id asc");
        List<User> users = userMapper.selectByExample(userExample);

        //数据库实体类 -> 返回给前端的vo类
        List<UserVo> resList = new ArrayList<>();
        for (User user :users) {
            resList.add(UserVo.parse(user));
        }

        //分页结果封装，有bug，明天看
//        Page page = (Page) users;

        pagingResult.setTn(1L);
        pagingResult.setCn(1);
        pagingResult.setSn(20);
        pagingResult.setItems(resList);
        return pagingResult;
    }
}

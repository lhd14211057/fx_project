package com.fffx.project.vo;


import com.fffx.project.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * vo: 返回给前端的对象类，和前端交互用
 */
@Data
@ApiModel(description = "用户信息")
public class UserVo {

    @ApiModelProperty(value = "id主键", name = "id", allowableValues = "range[1, infinity]")
    private Integer id;

    @ApiModelProperty(value = "用户名", name = "name", example = "fffx")
    private String name;

    /**
     * 数据库实体类和vo类的快速转换函数，每个vo尽量有一个
     * @param user 数据库实体类
     * @return vo类
     */
    public static UserVo parse(User user) {
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setName(user.getName());
        return userVo;
    }
}

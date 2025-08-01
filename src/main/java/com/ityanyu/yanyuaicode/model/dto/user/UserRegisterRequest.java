/**
 * @projectName yanyu-ai-code
 * @package com.ityanyu.yanyuaicode.model.dto
 * @className com.ityanyu.yanyuaicode.model.dto.user.UserRegisterRequest
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ityanyu.yanyuaicode.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * UserRegisterRequest
 * @description 用户注册请求类
 * @author dengling
 * @date 2025/8/1 15:17
 * @version 1.0
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 确认密码
     */
    private String checkPassword;
}


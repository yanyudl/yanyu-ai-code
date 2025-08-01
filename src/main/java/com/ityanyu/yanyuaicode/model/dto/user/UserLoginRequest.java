/**
 * @projectName yanyu-ai-code
 * @package com.ityanyu.yanyuaicode.model.dto
 * @className com.ityanyu.yanyuaicode.model.dto.user.UserLoginRequest
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ityanyu.yanyuaicode.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * UserLoginRequest
 * @description 用户登录请求类
 * @author dengling
 * @date 2025/8/1 15:39
 * @version 1.0
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;
}


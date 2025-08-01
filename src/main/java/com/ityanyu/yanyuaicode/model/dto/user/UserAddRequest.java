/**
 * @projectName yanyu-ai-code
 * @package com.ityanyu.yanyuaicode.model.dto.user
 * @className com.ityanyu.yanyuaicode.model.dto.user.UserAddRequesy
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ityanyu.yanyuaicode.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * UserAddRequesy
 * @description 用户添加请求类
 * @author dengling
 * @date 2025/8/1 17:24
 * @version 1.0
 */
@Data
public class UserAddRequest implements Serializable {

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色: user, admin
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}


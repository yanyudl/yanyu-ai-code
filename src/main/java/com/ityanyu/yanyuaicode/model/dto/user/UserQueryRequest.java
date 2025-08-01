/**
 * @projectName yanyu-ai-code
 * @package com.ityanyu.yanyuaicode.model.dto.user
 * @className com.ityanyu.yanyuaicode.model.dto.user.UserQueryRequest
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ityanyu.yanyuaicode.model.dto.user;

import java.io.Serializable;

import com.ityanyu.yanyuaicode.common.PageRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * UserQueryRequest
 * @description 用户查询请求类
 * @author dengling
 * @date 2025/8/1 17:26
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}


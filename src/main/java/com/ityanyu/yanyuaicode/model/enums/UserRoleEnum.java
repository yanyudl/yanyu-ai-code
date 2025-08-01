/**
 * @projectName yanyu-ai-code
 * @package com.ityanyu.yanyuaicode.model.enums
 * @className com.ityanyu.yanyuaicode.model.enums.UserEnum
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ityanyu.yanyuaicode.model.enums;

import cn.hutool.core.util.ObjUtil;
import lombok.Getter;

/**
 * UserEnum
 * @description 用户角色枚举类
 * @author dengling
 * @date 2025/8/1 15:11
 * @version 1.0
 */
@Getter
public enum UserRoleEnum {

 USER("用户", "user"),
 ADMIN("管理员", "admin");

 private final String text;

 private final String value;

 UserRoleEnum(String text, String value) {
  this.text = text;
  this.value = value;
 }

 /**
  * 根据 value 获取枚举
  *
  * @param value 枚举值的value
  * @return 枚举值
  */
 public static UserRoleEnum getEnumByValue(String value) {
  if (ObjUtil.isEmpty(value)) {
   return null;
  }
  for (UserRoleEnum anEnum : UserRoleEnum.values()) {
   if (anEnum.value.equals(value)) {
    return anEnum;
   }
  }
  return null;
 }
}


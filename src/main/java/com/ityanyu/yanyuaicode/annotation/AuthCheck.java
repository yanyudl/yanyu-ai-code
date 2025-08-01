/**
 * @projectName yanyu-ai-code
 * @package com.ityanyu.yanyuaicode.annotation
 * @className com.ityanyu.yanyuaicode.annotation.AuthCheck
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ityanyu.yanyuaicode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * AuthCheck
 * @description 自定义注解校验权限
 * @author dengling
 * @date 2025/8/1 16:06
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {

 /**
  * 必须有某个角色
  */
 String mustRole() default "";
}


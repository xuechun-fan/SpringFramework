package com.fxc.shirodemo.domain;

import lombok.*;

/**
 * 用户DO类
 *
 * @author FXC
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDO {
    /** 用户记录ID */
    private Integer id;
    /** 用户名 */
    private String username;
    /** 用户密码 */
    private String password;
}
package com.example.done1.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Admin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    private long id;
    private String userCode;
    private String userName;
    private String nickName;
    private String userPwd;
    private Date createDate;
    private Date updateDate;
}

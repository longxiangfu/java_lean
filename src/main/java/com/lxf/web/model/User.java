package com.lxf.web.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_user")
@org.hibernate.annotations.Table(appliesTo = "tb_user", comment = "用户表")
public class User {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "userName", unique = true, nullable = false, columnDefinition = "varchar(64) comment '用户名'")
    private String userName;

    @Column(name = "passWord", nullable = false, columnDefinition = "varchar(64) comment '密码'")
    private String passWord;

    @Column(name = "email", columnDefinition = "varchar(64) comment '邮箱'")
    private String email;

}

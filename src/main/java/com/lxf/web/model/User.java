package com.lxf.web.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_user")
@DynamicUpdate
@org.hibernate.annotations.Table(appliesTo = "tb_user", comment = "用户表")
public class User {

    //数据库主键自增，但是hibernate额外维护了一张主键id表，每次新增都会修改该表的id,并且不能批量，后续修改为双buffer方案，支持分布式
    //不用uuid，是因为不管是插入还是查询，效率都没有自增主键高
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "userName", unique = true, nullable = false, columnDefinition = "varchar(64) comment '用户名'")
    private String userName;

    @Column(name = "passWord", nullable = false, columnDefinition = "varchar(64) comment '密码'")
    private String passWord;

    @Column(name = "email", columnDefinition = "varchar(64) comment '邮箱'")
    private String email;

}

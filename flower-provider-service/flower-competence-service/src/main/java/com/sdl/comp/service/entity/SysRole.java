package com.sdl.comp.service.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @program flowerPaaS
 * @description:
 * @author: songdeling
 * @create: 2019/12/24 14:57
 */
@Entity
@Table(name = "sys_role")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysRole implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 是否有效: true 有效/未删除, false 无效/已删除
     */
    private Boolean valid;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}

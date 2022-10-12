package com.example.lsbcrudjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {


    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    private String password;

    /**
     * 邮箱
     */
    private String adress;

    private Integer status;


}

package com.david.example.DTO;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @version $Id: null.java, v 1.0 2019/8/30 9:39 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class OtherQuest implements Serializable {
    private static final long serialVersionUID = 7662290559400788838L;

    @NotNull(message = "age 不能为空")
    private Integer age;

    private Integer sex;

    @NotNull(message = "名字不能为空")
    private String name;

    public Integer getAge() {
        return age;
    }

    public OtherQuest setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public OtherQuest setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getName() {
        return name;
    }

    public OtherQuest setName(String name) {
        this.name = name;
        return this;
    }
}

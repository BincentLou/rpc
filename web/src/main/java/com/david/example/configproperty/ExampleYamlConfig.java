package com.david.example.configproperty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @version $Id: null.java, v 1.0 2019/8/24 11:55 AM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:yaml配置文件简单示例
 * @since 1.0
 **/
//@Component
//@Validated
//@ConfigurationProperties(prefix = "my")
public class ExampleYamlConfig {

    @NotNull
    private List<String> servers = new ArrayList<>();

    @Valid
    private Security security = new Security();

    public Security getSecurity() {
        return security;
    }

    public ExampleYamlConfig setSecurity(Security security) {
        this.security = security;
        return this;
    }

    public List<String> getServers() {
        return this.servers;
    }

    public class Security{
        @NotNull
        private String username;

        @NotNull
        private List<String>roles = new ArrayList<>();

        public String getUsername() {
            return username;
        }

        public Security setUsername(String username) {
            this.username = username;
            return this;
        }

        public List<String> getRoles() {
            return roles;
        }

        public Security setRoles(List<String> roles) {
            this.roles = roles;
            return this;
        }
    }
}

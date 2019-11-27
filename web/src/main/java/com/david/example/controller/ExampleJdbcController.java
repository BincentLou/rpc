package com.david.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @version $Id: null.java, v 1.0 2019/9/5 5:08 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:
 * @since 1.0
 **/
@RestController
public class ExampleJdbcController {

    private Logger logger = LoggerFactory.getLogger(ExampleJdbcController.class);

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/datasource")
    public String dataSource(){
        try {
            return dataSource.getConnection().getSchema();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }
}

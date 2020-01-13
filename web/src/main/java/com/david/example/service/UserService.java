package com.david.example.service;



import com.david.example.DTO.BaseResponse;
import com.david.example.entity.User;

import java.util.List;

/**
 * @author yangchangkui
 */
public interface UserService {
    /**
     *  获取所有用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 获取值日生邮件，有可能有多个邮件
     * @return
     */
    List<String> getDutyUserEmails();

    /**
     * 获取值日生
     * @return
     */
    BaseResponse getAllDutyUser();

    /**
     * 保存添加用户
     * @return
     */
    BaseResponse saveUser(User model);

    /**
     * 新增或更新值日生
     * @param id
     * @param strDate
     * @return
     */
    int batchDutyUser(int id, String strDate);
}

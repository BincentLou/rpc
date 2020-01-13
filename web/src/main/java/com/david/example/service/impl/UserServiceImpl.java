package com.david.example.service.impl;

import com.david.example.DTO.BaseResponse;
import com.david.example.entity.DutyUser;
import com.david.example.entity.FoundationUser;
import com.david.example.entity.FoundationUserExample;
import com.david.example.entity.HolidayDuty;
import com.david.example.entity.HolidayDutyExample;
import com.david.example.entity.User;
import com.david.example.mapper.FoundationUserMapper;
import com.david.example.mapper.HolidayDutyMapper;
import com.david.example.mapper.UserMapper;
import com.david.example.service.UserService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yangchangkui
 * @date: 2018-11-03 10:43
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private FoundationUserMapper foundationUserMapper;

    @Resource
    private HolidayDutyMapper holidayDutyMapper;

    @Override
    public List<User> getAllUser() {
        FoundationUserExample example = new FoundationUserExample();
        example.createCriteria().andUserStatusEqualTo("0");
        List<FoundationUser> userList = foundationUserMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)){
            return null;
        }
        List<User> result = new ArrayList<>(userList.size());
        for (FoundationUser user:userList) {
            User item = new User();
            item.setEmail(user.getMobile());
            item.setName(user.getUserName());
            item.setId(Integer.valueOf(user.getUserWorkNumber()));
            item.setMotto(user.getDepartName());
            result.add(item);
        }
        return result;
    }

    @Override
    public List<String> getDutyUserEmails() {
        DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currDate = sf.format(new Date());
        return userMapper.queryDutyUserEmails(currDate);
    }

    @Override
    public BaseResponse getAllDutyUser() {

        HolidayDutyExample example = new HolidayDutyExample();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,-1);
        Date time1 =cal.getTime();
        cal.set(Calendar.YEAR,1);
        Date time2= cal.getTime();
        example.createCriteria().andDutyDateBetween(time1,time2);
        List<HolidayDuty> duty = holidayDutyMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(duty)){
            return null;
        }
        List workNumerList = new ArrayList<String>();
        duty.forEach(item->{workNumerList.add(item.getUserWorkNumber());});

        FoundationUserExample userExample = new FoundationUserExample();
        userExample.createCriteria().andUserWorkNumberIn(workNumerList);
        List<FoundationUser> userList = foundationUserMapper.selectByExample(userExample);
        Map workNumMap = new HashMap<String,String>();
        userList.forEach(item->{workNumMap.put(item.getUserWorkNumber(),item.getUserName());});

        Map result = new HashMap();
        for (HolidayDuty item:duty
             ) {
            result.put(item.getDutyDate(),workNumMap.get(item.getUserWorkNumber()));
        }
        List<Map> mapList = Arrays.asList(result);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(mapList);

        return baseResponse;
    }

    @Override
    public BaseResponse saveUser(User model) {

//        int line = userMapper.insertUser(model);

        return new BaseResponse(0);
    }

    @Override
    public int batchDutyUser(int id, String strDate) {
        int line = 0;
        DutyUser dutyUser = userMapper.queryDutyUser(id,strDate);
        if(dutyUser != null){
            line = userMapper.updateDutyUser(id,strDate);
        }else{
            line = userMapper.insertDutyUser(id,strDate);
        }
        return line;
    }
}

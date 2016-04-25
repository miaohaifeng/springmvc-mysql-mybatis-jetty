package com.madhoue.dsp.uadata.service.user;

import com.madhoue.dsp.uadata.mapper.UserMapper;
import com.madhoue.dsp.uadata.models.User;
import com.madhoue.dsp.uadata.service.IBaseService;

import java.util.List;

/**
 * Created by miaohaifeng
 * on 2016/4/23.
 */
public interface IUserService extends IBaseService<UserMapper, User> {
    List<User> selectAll();
}

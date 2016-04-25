package com.madhoue.dsp.uadata.service.user;

import com.madhoue.dsp.uadata.mapper.UserMapper;
import com.madhoue.dsp.uadata.models.User;
import com.madhoue.dsp.uadata.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by miaohaifeng
 * on 2016/4/23.
 */
@Service
public class UserService extends BaseService<UserMapper, User> implements IUserService {
    private UserMapper mapper;

    @Override
    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
        super.setMapper(mapper);
    }

    @Override
    public List<User> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Long addBasic(User obj) throws Exception {
        mapper.insert(obj);
        return Long.parseLong(obj.getId()+"");
    }

    @Override
    public void modifyBasic(User obj) throws Exception {
        mapper.updateByPrimaryKey(obj);
    }

    @Override
    public void delBasic(User obj) throws Exception {
        mapper.deleteByPrimaryKey(obj.getId());
    }
}

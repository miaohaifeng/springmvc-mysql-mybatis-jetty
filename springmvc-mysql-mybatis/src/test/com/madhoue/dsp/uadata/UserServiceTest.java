package com.madhoue.dsp.uadata;

import com.madhoue.dsp.uadata.models.User;
import com.madhoue.dsp.uadata.service.user.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by miaohaifeng
 * on 2016/4/25.
 */
public class UserServiceTest extends BaseServiceTest {
    @Autowired
    private IUserService service;
    @Test
    public void selectAllTest(){
        List<User> users = service.selectAll();
        for (User user : users) {
            System.out.println(user.getId());
        }
    }
}

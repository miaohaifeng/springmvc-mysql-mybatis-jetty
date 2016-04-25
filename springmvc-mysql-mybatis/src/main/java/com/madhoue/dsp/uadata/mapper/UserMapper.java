package com.madhoue.dsp.uadata.mapper;

import com.madhoue.dsp.uadata.models.User;

import java.util.List;

public interface UserMapper extends IBaseMapper<User> {
    List<User> selectAll();
}
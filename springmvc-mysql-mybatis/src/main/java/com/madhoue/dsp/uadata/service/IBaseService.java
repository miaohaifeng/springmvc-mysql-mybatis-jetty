package com.madhoue.dsp.uadata.service;

import com.madhoue.dsp.uadata.mapper.IBaseMapper;
import com.madhoue.dsp.uadata.models.common.RollPage;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Map;


/**
 * 基础的 Service
 */
public interface IBaseService<T extends IBaseMapper<M>, M> {

    /**
     * 增加记录
     *
     * @param obj
     * @throws Exception
     */
    Long addBasic(M obj) throws Exception;

    /**
     * 修改记录
     *
     * @param obj
     * @throws Exception
     */
    void modifyBasic(M obj) throws Exception;

    /**
     * 删除记录
     *
     * @param obj
     * @throws Exception
     */
    void delBasic(M obj) throws Exception;

    /**
     * 根据主键查询记录
     *
     * @param seq
     * @return
     * @throws Exception
     */
    <K> M findObjByKey(K seq) throws Exception;

    /**
     * 根据条件查询记录
     *
     * @param params
     * @return
     * @throws Exception
     */
    M findObj(Map<String, Object> params) throws Exception;

    /**
     * 根据条件查询列表
     *
     * @param params
     * @param order
     * @return
     * @throws Exception
     */
    List<M> findListByParams(Map<String, Object> params, Order order) throws Exception;

    /**
     * 根据条件查询 列表（分页查询）
     *
     * @param params
     * @param order
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    RollPage<M> findListPageByParams(Map<String, Object> params, Order order, Integer pageNum, Integer pageSize) throws Exception;
}

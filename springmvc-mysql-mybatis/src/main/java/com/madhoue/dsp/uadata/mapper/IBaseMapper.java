package com.madhoue.dsp.uadata.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by miaohaifeng
 * on 2016/2/19.
 */
public interface IBaseMapper<T> {
    /**
     * 获取 序列号
     *
     * @return
     */
    Long getIdValue();

    /**
     * 插入记录
     *
     * @param obj
     * @return
     */
    int insert(T obj);

    /**
     * 插入记录(有效字段,即非空字段)
     *
     * @param obj
     * @return
     */
    int insertSelective(T obj);

    /**
     * 物理删除记录
     *
     * @param seq
     * @return
     */
    <K> int deleteByPrimaryKey(K seq);

    /**
     * 更新记录
     *
     * @param obj
     * @return
     */
    int updateByPrimaryKey(T obj);

    /**
     * 更新记录(有效字段,即非空字段)
     *
     * @param obj
     * @return
     */
    int updateByPrimaryKeySelective(T obj);

    /**
     * 根据主键 返回记录
     *
     * @param seq
     * @return
     */
    <K> T selectByPrimaryKey(K seq);
    /**
     * 根据 条件返回记录
     *
     * @param params
     * @return
     */
    T selectByParams(@Param(value = "params") Map<String, Object> params);

    /**
     * 查询 符合条件的记录总数
     *
     * @param params
     * @return
     */
    int selectCountByParams(@Param(value = "params") Map<String, Object> params);


    /**
     * 分页查询 记录
     *
     * @param params 查询条件
     * @param pageOffset 开始游标
     * @param pageSize 每页显示的数量
     * @param orderParam 排序参数
     * @return
     */
    List<T> selectListByParams(@Param(value = "params") Map<String, Object> params,
                               @Param(value = "pageOffset") Integer pageOffset,
                               @Param(value = "pageSize") Integer pageSize,
                               @Param(value = "orderParam") String orderParam);

    /**
     * 根据条件 查询所有记录
     *
     * @param params 查询条件
     * @param orderParam 排序参数
     * @return
     */
    List<T> selectAllListByParams(@Param(value = "params") Map<String, Object> params,
                                  @Param(value = "orderParam") String orderParam);
}

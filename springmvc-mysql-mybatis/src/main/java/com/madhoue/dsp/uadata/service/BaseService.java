package com.madhoue.dsp.uadata.service;

import com.madhoue.dsp.uadata.mapper.IBaseMapper;
import com.madhoue.dsp.uadata.models.common.RollPage;
import com.madhoue.dsp.uadata.toolbox.util.ClearNullUtil;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 基本Service实现类
 */
@Service
public abstract class BaseService<T extends IBaseMapper<M>,M> implements IBaseService<T, M> {

    protected  Integer pageSizeDefault = 10;

	protected T mapper;

	public void setMapper(T mapper) {
		this.mapper = mapper;
	}

	public abstract Long addBasic(M obj) throws Exception;

	public abstract void modifyBasic(M obj) throws Exception;

	public abstract void delBasic(M obj) throws Exception;


	public <K> M findObjByKey(K seq) throws Exception {
		return mapper.selectByPrimaryKey(seq);
	}

	public M findObj(Map<String, Object> params) throws Exception {
		ClearNullUtil.mapClear(params);
		return mapper.selectByParams(params);
	}

	public List<M> findListByParams(Map<String, Object> params, Order order)
			throws Exception {
		ClearNullUtil.mapClear(params);
		String orderParam=(order==null)?null:order.toString();

		return mapper.selectListByParams(params, null, null, orderParam);
	}

	public RollPage<M> findListPageByParams(Map<String, Object> params,
			Order order, Integer pageNum, Integer pageSize) throws Exception {

		ClearNullUtil.mapClear(params);
		String orderParam=(order==null)?null:order.toString();

		Integer recordSum= mapper.selectCountByParams(params);

		RollPage<M> rollPage=new RollPage<M>();

		rollPage.setRecordSum(recordSum);

		if (pageSize==null)
			rollPage.setPageSize(pageSizeDefault);
		else
			rollPage.setPageSize(pageSize);

		pageNum=(pageNum==null)?1:pageNum;

		rollPage.setPageNum(pageNum);

//		Integer startIndex=(rollPage.getPageNum() - 1) * rollPage.getPageSize();
//		Integer endIndex=startIndex+rollPage.getPageSize();
		Integer pageOffset=(rollPage.getPageNum() - 1) * rollPage.getPageSize();
        pageSize=rollPage.getPageNum()*rollPage.getPageSize();

        if (recordSum>0) {
//			rollPage.setRecordList(mapper.selectListByParams(params, startIndex, endIndex, orderParam));
			rollPage.setRecordList(mapper.selectListByParams(params, pageOffset, pageSize, orderParam));
		}
		else{
			rollPage.setRecordList(new ArrayList<M>());
		}
		return rollPage;

	}

}

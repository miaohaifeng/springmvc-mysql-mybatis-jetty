package com.madhoue.dsp.uadata.models.common;

/**
 * 排序类
 *
 */
public class Order implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private String column;
	private String orderType;
	
	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Order( String column, String orderType){
		this.column=column;
		this.orderType=orderType;
	}

    public static Order desc(String column){
		Order order=new Order(column, "desc");
		return order;
	}
	
	public static Order asc(String column){
		Order order=new Order( column, "asc");
		return order;
	}
	
	
	@Override
	public String toString(){
		String orderColumn=this.column;
		StringBuffer sb=new StringBuffer();
		sb.append(orderColumn)
		  .append(" ")
		  .append(this.orderType);
		
		return sb.toString();
	}

}

package com.mamba.popidea.model.common.result;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mamba.popidea.exception.ErrorCodes;

import java.util.ArrayList;
import java.util.List;


@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class RestResp<T> {
	
	private Integer code = 200;
	private String msg = "";
	private RestData<T> data = null;

	public RestResp() {

	}


	public RestResp(Integer code){
		this(code,null);
	}

	public RestResp(Integer code, String msg){
		this.code = code;
		this.msg = msg == null? ErrorCodes.getErrorInfo(code).toString():msg;
	}

	public RestResp(T data){
		this(data==null?new RestData<T>(new ArrayList<T>()):new RestData<T>(data));
	}

	public RestResp(List<T> data){
		this(data==null?new RestData<T>(new ArrayList<T>()):new RestData<T>(data));
	}

	public RestResp(List<T> data, Long count){
		this(data);
		this.data.setRsCount(count);
	}

	public RestResp(List<T> data, Integer count){
		this(data);
		this.data.setRsCount(Long.valueOf(count));
	}

	public RestResp(RestData<T> data){
		this.data = data==null?new RestData<T>(new ArrayList<T>()):data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public RestData<T> getData() {
		return data;
	}

	public void setData(RestData<T> data) {
		this.data = data;
	}

	
}

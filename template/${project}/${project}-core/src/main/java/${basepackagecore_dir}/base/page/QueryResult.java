/**
 * Copyright 2011 Eric Microsystems,Inc. All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package ${basepackagecore}.base.page;

import java.util.List;

/***
 * 分页
 */
public class QueryResult<T> {

	/** 查询得出的数据List **/
	private List<T> resultList;
	/** 查询得出的总数 **/
	private int totalRecord;

	public QueryResult() {

	}

	public QueryResult(List<T> resultList, int totalRecord) {
		this.resultList = resultList;
		this.totalRecord = totalRecord;

	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
}

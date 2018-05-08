package com.beini.paging.domain;

import java.io.Serializable;

public abstract class AbstractPagingRequest implements Pagingable, Serializable {
	private static final long serialVersionUID = -5210923445890939451L;
	private final int page;
	private final int size;

	/**
	 * 构造最基本的分页信息
	 * 
	 * @param page
	 *            必须大于等于0
	 * @param size
	 *            必须大于等于0
	 */
	public AbstractPagingRequest(int page, int size) {

		if (page < 0) {
			throw new IllegalArgumentException("页码必须大于等于0!");
		}

		if (size < 1) {
			throw new IllegalArgumentException("页码条数必须大于等于0!");
		}

		this.page = page;
		this.size = size;
	}

	public int getPageSize() {
		return size;
	}

	public int getPageNumber() {
		return page;
	}

	public int getOffset() {
		return page * size;
	}

	public boolean hasPrevious() {
		return page > 0;
	}

	public Pagingable previousOrFirst() {
		return hasPrevious() ? previous() : first();
	}

	public abstract Pagingable next();

	public abstract Pagingable previous();

	public abstract Pagingable first();

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;

		result = prime * result + page;
		result = prime * result + size;

		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		AbstractPagingRequest other = (AbstractPagingRequest) obj;
		return this.page == other.page && this.size == other.size;
	}
}

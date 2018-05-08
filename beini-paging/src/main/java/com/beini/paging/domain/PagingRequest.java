package com.beini.paging.domain;

import com.beini.paging.domain.PropertiesSort.Direction;

/**
 * 分页请求信息
 * @author lb_chen
 */
public class PagingRequest extends AbstractPagingRequest {
	private static final long serialVersionUID = -2187238324540426773L;

	private final PropertiesSort sort;

	public PagingRequest(int page, int size) {
		this(page, size, null);
	}

	public PagingRequest(int page, int size, PropertiesSort sort) {
		super(page, size);
		this.sort = sort;
	}

	public PagingRequest(int page, int size, Direction direction, String... properties) {
		this(page, size, new PropertiesSort(direction, properties));
	}

	@Override
	public Pagingable next() {
		return new PagingRequest(getPageNumber() + 1, getPageSize(), getSort());
	}

	@Override
	public Pagingable previous() {
		return getPageNumber() == 0 ? this : new PagingRequest(getPageNumber() - 1, getPageSize(), getSort());
	}

	@Override
	public Pagingable first() {
		return new PagingRequest(0, getPageSize(), getSort());
	}

	public PropertiesSort getSort() {
		return sort;
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PagingRequest)) {
			return false;
		}

		PagingRequest that = (PagingRequest) obj;

		boolean sortEqual = this.sort == null ? that.sort == null : this.sort.equals(that.sort);

		return super.equals(that) && sortEqual;
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + (null == sort ? 0 : sort.hashCode());
	}

	@Override
	public String toString() {
		return String.format("Page request [number: %d, size %d, sort: %s]", getPageNumber(), getPageSize(),
				sort == null ? null : sort.toString());
	}
}

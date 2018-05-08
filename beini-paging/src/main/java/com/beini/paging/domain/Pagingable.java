package com.beini.paging.domain;

public interface Pagingable {
	int getPageNumber();

	int getPageSize();

	int getOffset();

	boolean hasPrevious();
}

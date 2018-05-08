package com.beini.paging.domain;

import java.util.List;

import org.springframework.core.convert.converter.Converter;

public interface Slice<T> extends Iterable<T> {
	int getNumber();

	int getSize();

	int getNumberOfElements();

	List<T> getContent();

	boolean hasContent();

	PropertiesSort getSort();

	boolean isFirst();

	boolean isLast();

	boolean hasNext();

	boolean hasPrevious();

	Pagingable nextPageable();

	Pagingable previousPageable();

	<S> Slice<S> map(Converter<? super T, ? extends S> converter);
}
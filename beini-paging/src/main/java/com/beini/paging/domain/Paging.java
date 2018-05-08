package com.beini.paging.domain;

import org.springframework.core.convert.converter.Converter;

public interface Paging<T> extends Slice<T> {
	int getTotalPagings();

	long getTotalElements();

	<S> Paging<S> map(Converter<? super T, ? extends S> converter);
}

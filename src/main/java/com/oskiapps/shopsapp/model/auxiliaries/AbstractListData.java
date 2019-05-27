package com.oskiapps.shopsapp.model.auxiliaries;

import java.util.List;

public class AbstractListData {

	private List<?> items;

	private PaginationData paginationData;

	public List<?> getItems() {
		return items;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}

	public PaginationData getPaginationData() {
		return paginationData;
	}

	public void setPaginationData(PaginationData paginationData) {
		this.paginationData = paginationData;
	}

}

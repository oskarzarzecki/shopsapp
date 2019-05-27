package com.oskiapps.shopsapp.model.auxiliaries;

public class PaginationData {

	private int itemsCount = 0;

	private int pageSize = 0;

	private int adjacentPages = 0;

	private boolean showArrows = false;

	public int getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getAdjacentPages() {
		return adjacentPages;
	}

	public void setAdjacentPages(int adjacentPages) {
		this.adjacentPages = adjacentPages;
	}

	public boolean isShowArrows() {
		return showArrows;
	}

	public void setShowArrows(boolean showArrows) {
		this.showArrows = showArrows;
	}

}

package com.oskiapps.shopsapp.engine.config.properties.customer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("shops.app.auctions.list")
public class AuctionsListProperties {

	private int nameMaxLength;

	private int descriptionMaxLength;

	private int pageSize;

	private int paginationAdjacentPages;

	private boolean paginationShowArrows;

	public int getNameMaxLength() {
		return nameMaxLength;
	}

	public void setNameMaxLength(int nameMaxLength) {
		this.nameMaxLength = nameMaxLength;
	}

	public int getDescriptionMaxLength() {
		return descriptionMaxLength;
	}

	public void setDescriptionMaxLength(int descriptionMaxLength) {
		this.descriptionMaxLength = descriptionMaxLength;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPaginationAdjacentPages() {
		return paginationAdjacentPages;
	}

	public void setPaginationAdjacentPages(int paginationAdjacentPages) {
		this.paginationAdjacentPages = paginationAdjacentPages;
	}

	public boolean isPaginationShowArrows() {
		return paginationShowArrows;
	}

	public void setPaginationShowArrows(boolean paginationShowArrows) {
		this.paginationShowArrows = paginationShowArrows;
	}

}

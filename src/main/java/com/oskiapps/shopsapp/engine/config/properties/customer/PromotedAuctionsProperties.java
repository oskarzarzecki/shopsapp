package com.oskiapps.shopsapp.engine.config.properties.customer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("shops.app.promoted.auctions")
public class PromotedAuctionsProperties {

	private int itemsCount;

	private int nameMaxLength;

	private int descriptionMaxLength;

	public int getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;
	}

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

}

package com.oskiapps.shopsapp.repository.specification;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import com.oskiapps.shopsapp.model.entities.Auction;

public class AuctionSpecs {

	public static Specification<Auction> categoryIs(long id) {
		return (root, query, builder) -> builder.equal(root.get("product").get("productCategory").get("id"), id);
	}

	public static Specification<Auction> priceBetween(BigDecimal priceFrom, BigDecimal priceTo) {
		return (root, query, builder) -> {
			if (priceTo.longValue() == 0) {
				return builder.greaterThanOrEqualTo(root.get("priceBrutto"), priceFrom);
			}
			return builder.between(root.get("priceBrutto"), priceFrom.add(new BigDecimal(-0.01)),
					priceTo.add(new BigDecimal(0.01)));
		};
	}

	public static Specification<Auction> dateBetween(Date dateFrom, Date dateTo) {
		return (root, query, builder) -> {
			if (dateFrom == null && dateTo == null) {
				return null;
			} else if (dateFrom != null && dateTo == null) {
				return builder.greaterThan(root.get("dateFrom"), dateFrom);
			} else if (dateFrom == null && dateTo != null) {
				return builder.lessThan(root.get("dateFrom"), dateTo);
			} else if (dateFrom != null && dateTo != null) {
				return builder.between(root.get("dateFrom"), dateFrom, dateTo);
			}
			return null;
		};
	}

}

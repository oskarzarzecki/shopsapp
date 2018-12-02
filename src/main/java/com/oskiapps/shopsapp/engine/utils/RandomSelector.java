package com.oskiapps.shopsapp.engine.utils;

import java.util.List;
import java.util.Random;

import com.oskiapps.shopsapp.model.Auction;

public class RandomSelector {

	private Random rand = new Random();
	private int sum = 0;

	public RandomSelector(List<Auction> auctions) {
		for (Auction auction : auctions) {
			sum = sum + auction.getPromoted();
		}
	}

	public Auction getRandomAuction(List<Auction> auctions) {
		int index = rand.nextInt(sum);
		int sum = 0;
		int i = 0;
		while (sum < index) {
			sum = sum + auctions.get(i++).getPromoted();
		}
		return auctions.remove(Math.max(0, i - 1));
	}

}

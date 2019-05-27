import { TestBed } from '@angular/core/testing';

import { ShopAuctionListService } from './shop-auction-list.service';

describe('ShopAuctionListService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ShopAuctionListService = TestBed.get(ShopAuctionListService);
    expect(service).toBeTruthy();
  });
});

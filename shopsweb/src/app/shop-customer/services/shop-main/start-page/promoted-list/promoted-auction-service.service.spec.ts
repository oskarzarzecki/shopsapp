import { TestBed, inject } from '@angular/core/testing';

import { PromotedAuctionService } from './promoted-auction.service';

describe('PromotedProductsServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PromotedAuctionService]
    });
  });

  it('should be created', inject([PromotedAuctionService], (service: PromotedAuctionService) => {
    expect(service).toBeTruthy();
  }));
});

import { TestBed } from '@angular/core/testing';

import { AuctionForUserService } from './auction-for-user.service';

describe('AuctionForUserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AuctionForUserService = TestBed.get(AuctionForUserService);
    expect(service).toBeTruthy();
  });
});

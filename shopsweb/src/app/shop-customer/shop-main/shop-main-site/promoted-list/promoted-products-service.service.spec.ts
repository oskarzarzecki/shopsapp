import { TestBed, inject } from '@angular/core/testing';

import { PromotedProductsService } from './promoted-products.service';

describe('PromotedProductsServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PromotedProductsService]
    });
  });

  it('should be created', inject([PromotedProductsService], (service: PromotedProductsService) => {
    expect(service).toBeTruthy();
  }));
});

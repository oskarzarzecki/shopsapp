import { TestBed, inject } from '@angular/core/testing';

import { PromotedProductsServiceService } from './promoted-products-service.service';

describe('PromotedProductsServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PromotedProductsServiceService]
    });
  });

  it('should be created', inject([PromotedProductsServiceService], (service: PromotedProductsServiceService) => {
    expect(service).toBeTruthy();
  }));
});

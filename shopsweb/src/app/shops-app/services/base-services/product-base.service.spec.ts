import { TestBed } from '@angular/core/testing';

import { ProductBaseService } from './product-base.service';

describe('ProductBaseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProductBaseService = TestBed.get(ProductBaseService);
    expect(service).toBeTruthy();
  });
});

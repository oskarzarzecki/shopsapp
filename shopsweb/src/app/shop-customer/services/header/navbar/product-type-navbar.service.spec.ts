import { TestBed } from '@angular/core/testing';

import { ProductTypeNavbarService } from './product-type-navbar.service';

describe('ProductTypeNavbarService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProductTypeNavbarService = TestBed.get(ProductTypeNavbarService);
    expect(service).toBeTruthy();
  });
});

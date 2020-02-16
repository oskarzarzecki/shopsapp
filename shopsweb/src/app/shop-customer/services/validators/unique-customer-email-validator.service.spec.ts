import { TestBed } from '@angular/core/testing';

import { UniqueCustomerEmailValidator } from './unique-customer-email-validator.service';

describe('UniqueCustomerEmailValidatorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UniqueCustomerEmailValidator = TestBed.get(UniqueCustomerEmailValidator);
    expect(service).toBeTruthy();
  });
});

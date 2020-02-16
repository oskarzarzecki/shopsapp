import { TestBed } from '@angular/core/testing';

import { CustomerAuthenticationService } from './customer-authentication.service';

describe('AuthenticationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerAuthenticationService = TestBed.get(CustomerAuthenticationService);
    expect(service).toBeTruthy();
  });
});

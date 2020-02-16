import { TestBed } from '@angular/core/testing';

import { ErrorHtppInterceptorService } from './error-htpp-interceptor.service';

describe('ErrorHtppInterceptorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ErrorHtppInterceptorService = TestBed.get(ErrorHtppInterceptorService);
    expect(service).toBeTruthy();
  });
});

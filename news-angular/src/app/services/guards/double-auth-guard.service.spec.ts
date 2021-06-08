import { TestBed } from '@angular/core/testing';

import { DoubleAuthGuardService } from './double-auth-guard.service';

describe('DoubleAuthGuardService', () => {
  let service: DoubleAuthGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DoubleAuthGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

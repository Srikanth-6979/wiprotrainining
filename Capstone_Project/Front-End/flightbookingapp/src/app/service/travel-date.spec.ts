import { TestBed } from '@angular/core/testing';

import { TravelDate } from './travel-date';

describe('TravelDate', () => {
  let service: TravelDate;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TravelDate);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { ChombreService } from './chombre.service';

describe('ChombreService', () => {
  let service: ChombreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChombreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

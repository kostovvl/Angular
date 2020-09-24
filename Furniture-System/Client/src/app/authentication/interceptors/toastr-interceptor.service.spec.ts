import { TestBed, inject } from '@angular/core/testing';

import { ToastrInterceptorService } from './toastr-interceptor.service';

describe('ToastrInterceptorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ToastrInterceptorService]
    });
  });

  it('should be created', inject([ToastrInterceptorService], (service: ToastrInterceptorService) => {
    expect(service).toBeTruthy();
  }));
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChombreDetailsComponent } from './chombre-details.component';

describe('ChombreDetailsComponent', () => {
  let component: ChombreDetailsComponent;
  let fixture: ComponentFixture<ChombreDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChombreDetailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChombreDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChombreListComponent } from './chombre-list.component';

describe('ChombreListComponent', () => {
  let component: ChombreListComponent;
  let fixture: ComponentFixture<ChombreListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChombreListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChombreListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChombreFormComponent } from './chombre-form.component';

describe('ChombreFormComponent', () => {
  let component: ChombreFormComponent;
  let fixture: ComponentFixture<ChombreFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChombreFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChombreFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

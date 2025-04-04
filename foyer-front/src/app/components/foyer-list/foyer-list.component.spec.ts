import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoyerListComponent } from './foyer-list.component';

describe('FoyerListComponent', () => {
  let component: FoyerListComponent;
  let fixture: ComponentFixture<FoyerListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FoyerListComponent]
    });
    fixture = TestBed.createComponent(FoyerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

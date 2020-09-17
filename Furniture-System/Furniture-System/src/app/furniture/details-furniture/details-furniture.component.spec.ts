import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsFurnitureComponent } from './details-furniture.component';

describe('DetailsFurnitureComponent', () => {
  let component: DetailsFurnitureComponent;
  let fixture: ComponentFixture<DetailsFurnitureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsFurnitureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsFurnitureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

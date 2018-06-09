import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PromotedListComponent } from './promoted-list.component';

describe('PromotedListComponent', () => {
  let component: PromotedListComponent;
  let fixture: ComponentFixture<PromotedListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PromotedListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PromotedListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

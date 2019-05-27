import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopMainLargeComponent } from './shop-main-large.component';

describe('ShopMainLargeComponent', () => {
  let component: ShopMainLargeComponent;
  let fixture: ComponentFixture<ShopMainLargeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopMainLargeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopMainLargeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

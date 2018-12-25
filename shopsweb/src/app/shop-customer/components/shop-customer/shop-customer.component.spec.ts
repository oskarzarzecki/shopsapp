import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopCustomerComponent } from './shop-customer.component';

describe('ShopCustomerComponent', () => {
  let component: ShopCustomerComponent;
  let fixture: ComponentFixture<ShopCustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopCustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

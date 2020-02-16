import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopAddressEditComponent } from './shop-address-edit.component';

describe('ShopAddressEditComponent', () => {
  let component: ShopAddressEditComponent;
  let fixture: ComponentFixture<ShopAddressEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopAddressEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopAddressEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

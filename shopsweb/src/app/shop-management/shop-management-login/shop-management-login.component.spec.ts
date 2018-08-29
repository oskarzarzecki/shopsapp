import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopManagementLoginComponent } from './shop-management-login.component';

describe('ShopManagementLoginComponent', () => {
  let component: ShopManagementLoginComponent;
  let fixture: ComponentFixture<ShopManagementLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopManagementLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopManagementLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

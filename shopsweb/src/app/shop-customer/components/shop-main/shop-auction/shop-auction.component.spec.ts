import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopAuctionComponent } from './shop-auction.component';

describe('ShopAuctionComponent', () => {
  let component: ShopAuctionComponent;
  let fixture: ComponentFixture<ShopAuctionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopAuctionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopAuctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopAuctionsListComponent } from './shop-auctions-list.component';

describe('ShopAuctionsListComponent', () => {
  let component: ShopAuctionsListComponent;
  let fixture: ComponentFixture<ShopAuctionsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopAuctionsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopAuctionsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

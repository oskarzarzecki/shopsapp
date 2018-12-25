import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PromotedAuctionComponent } from './promoted-auction.component';

describe('ProductAuctionComponent', () => {
  let component: PromotedAuctionComponent;
  let fixture: ComponentFixture<PromotedAuctionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PromotedAuctionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PromotedAuctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { Component, OnInit, Input } from '@angular/core';
import { PromotedAuction } from 'src/app/shop-customer/services/shop-main/start-page/promoted-list/promoted-auction';

@Component({
  selector: 'shop-promoted-auction',
  templateUrl: './promoted-auction.component.html',
  styleUrls: ['./promoted-auction.component.scss']
})
export class PromotedAuctionComponent implements OnInit {

  @Input()
  auction: PromotedAuction;

  constructor() { }

  ngOnInit() {
  }

}

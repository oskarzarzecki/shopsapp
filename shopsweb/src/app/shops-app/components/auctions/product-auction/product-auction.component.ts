import { Component, OnInit, Input } from '@angular/core';
import { ProductAuction } from 'src/app/shops-app/components/auctions/product-auction/product-auction';

@Component({
  selector: 'app-product-auction',
  templateUrl: './product-auction.component.html',
  styleUrls: ['./product-auction.component.scss']
})
export class ProductAuctionComponent implements OnInit {

  @Input()
  auction: ProductAuction;

  constructor() { }

  ngOnInit() {
  }

}

import { Component, OnInit, QueryList, AfterViewInit, ViewChildren } from '@angular/core';
import { PromotedProductsService } from '../../../../services/shop-main/start-page/promoted-list/promoted-products.service';
import { PromotedAuction } from '../../../../services/shop-main/start-page/promoted-list/promoted-auction';
import { PromotedAuctionComponent } from './product-auction/promoted-auction.component';


@Component({
  selector: 'shop-promoted-list',
  templateUrl: './promoted-list.component.html',
  styleUrls: ['./promoted-list.component.scss']
})
export class PromotedListComponent implements OnInit, AfterViewInit {

  @ViewChildren(PromotedAuctionComponent)
  auctionsComponenets: QueryList<PromotedAuctionComponent>;

  auctions: PromotedAuction[];

  constructor(private promotedProductsService: PromotedProductsService) { }

  ngOnInit() {
    this.getItems();
  }

  ngAfterViewInit(): void {
    let cc: PromotedAuctionComponent[] = this.auctionsComponenets.toArray();
    this.auctionsComponenets.changes.subscribe(c => {console.log(c.toArray()[1])});
  }

  getItems(): void {
    this.promotedProductsService.getPromotedAuctions().subscribe(
      result => {
        this.auctions = result;
        console.log(this.auctions);
      }
    );
  }

}

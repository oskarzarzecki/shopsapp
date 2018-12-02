import { Component, OnInit, ContentChildren, QueryList, AfterViewInit, AfterContentInit, ViewChildren } from '@angular/core';
import { PromotedProductsService } from './promoted-products.service';
import { ProductAuction } from '../../../../shops-app/components/auctions/product-auction/product-auction';
import { ProductAuctionComponent } from 'src/app/shops-app/components/auctions/product-auction/product-auction.component';


@Component({
  selector: 'app-shop-promoted-list',
  templateUrl: './promoted-list.component.html',
  styleUrls: ['./promoted-list.component.scss']
})
export class PromotedListComponent implements OnInit, AfterViewInit {

  @ViewChildren(ProductAuctionComponent)
  auctionsComponenets: QueryList<ProductAuctionComponent>;

  auctions: ProductAuction[];

  constructor(private promotedProductsService: PromotedProductsService) { }

  ngOnInit() {
    this.getItems();
  }

  ngAfterViewInit(): void {
    let cc: ProductAuctionComponent[] = this.auctionsComponenets.toArray();
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

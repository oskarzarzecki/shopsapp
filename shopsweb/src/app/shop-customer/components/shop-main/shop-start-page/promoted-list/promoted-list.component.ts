import { Component, OnInit, QueryList, AfterViewInit, ViewChildren } from '@angular/core';
import { PromotedAuctionService } from '../../../../services/shop-main/start-page/promoted-list/promoted-auction.service';
import { PromotedAuction } from '../../../../services/shop-main/start-page/promoted-list/promoted-auction';
import { PromotedAuctionComponent } from './promoted-auction/promoted-auction.component';
import { AuctionForUserService } from 'src/app/shop-customer/services/shop-main/shop-auction/auction-for-user.service';
import { ConfigService } from 'src/app/config/config.service';


@Component({
  selector: 'shop-promoted-list',
  templateUrl: './promoted-list.component.html',
  styleUrls: ['./promoted-list.component.scss']
})
export class PromotedListComponent implements OnInit {

  @ViewChildren(PromotedAuctionComponent)
  auctionsComponenets: QueryList<PromotedAuctionComponent>;

  auctions: PromotedAuction[];
  productImage: File;

  constructor(private promotedAuctionService: PromotedAuctionService, private auctionForUserService: AuctionForUserService,
    private config: ConfigService) { }

  ngOnInit() {
    this.getItems();
  }

  getItems(): void {
    this.promotedAuctionService.getPromotedAuctions().subscribe(
      result => {
        this.auctions = result;
        this.auctions.forEach(auction => {
          auction.idImage = this.auctionForUserService.getProductImageLink(auction.idProduct, auction.idImage);
        });
        console.log(this.auctions);
      }
    );
  }

}

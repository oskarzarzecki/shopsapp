import { Component, OnInit, QueryList, AfterViewInit, ViewChildren } from '@angular/core';
import { PromotedAuctionService } from '../../../../services/shop-main/shop-start-page/promoted-auction.service';
import { AuctionInCard } from '../../../../services/shop-main/auction-in-card';
import { AuctionForUserService } from 'src/app/shop-customer/services/shop-main/shop-auction/auction-for-user.service';


@Component({
  selector: 'shop-promoted-list',
  templateUrl: './promoted-list.component.html',
  styleUrls: ['./promoted-list.component.scss']
})
export class PromotedListComponent implements OnInit {

  auctions: AuctionInCard[];

  constructor(private promotedAuctionService: PromotedAuctionService, private auctionForUserService: AuctionForUserService) { }

  ngOnInit() {
    this.getItems();
  }

  getItems(): void {
    this.promotedAuctionService.getPromotedAuctions().subscribe(
      result => {
        this.auctions = result;
        console.log(this.auctions);
      }
    );
  }

}

import { Component, OnInit, Input } from '@angular/core';
import { AuctionInCard } from 'src/app/shop-customer/services/shop-main/auction-in-card';
import { ConfigService } from 'src/app/config/config.service';

@Component({
  selector: 'shop-auction-card',
  templateUrl: './auction-card.component.html',
  styleUrls: ['./auction-card.component.scss'],
  host: { 'class': 'card product-card mb-5' }
})
export class AuctionCardComponent implements OnInit {

  @Input()
  auction: AuctionInCard;

  constructor(private config: ConfigService) { }

  ngOnInit() {
  }

}

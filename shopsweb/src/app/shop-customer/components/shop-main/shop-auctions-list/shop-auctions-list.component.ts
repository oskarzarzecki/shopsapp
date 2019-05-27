import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { ConfigService } from 'src/app/config/config.service';
import { AuctionInCard } from 'src/app/shop-customer/services/shop-main/auction-in-card';
import { ShopAuctionListService } from 'src/app/shop-customer/services/shop-main/shop-auction-list/shop-auction-list.service';
import { AuctionForUserService } from 'src/app/shop-customer/services/shop-main/shop-auction/auction-for-user.service';
import { AbstractList } from 'src/app/shops-app/components/list/abstract-list';
import { ListInterface } from 'src/app/shops-app/components/list/list-interface';

@Component({
  selector: 'app-shop-auctions-list',
  templateUrl: './shop-auctions-list.component.html',
  styleUrls: ['./shop-auctions-list.component.scss']
})
export class ShopAuctionsListComponent implements OnInit, ListInterface {

  listData$: Observable<AbstractList<AuctionInCard>>;
  idCategory: number;
  page: number = 5;
  basePath = this.route.snapshot.url[0].path;

  constructor(private http: HttpClient, private config: ConfigService, private shopAuctionListService: ShopAuctionListService,
    private auctionForUserService: AuctionForUserService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.idCategory = 0;


    if (false) {
      this.router.navigate([this.route.snapshot.url[0].path + "/1/3"]);
    }

    this.listData$ = this.route.paramMap.pipe(
      switchMap(params => {
        this.idCategory = +params.get('id_category');
        this.page = +params.get('page');
        return this.shopAuctionListService.getAuctions(this.idCategory, this.page);
      })
    )
  }

  getBasePath(): string {
    return this.basePath + "/" + this.idCategory;
  }

}

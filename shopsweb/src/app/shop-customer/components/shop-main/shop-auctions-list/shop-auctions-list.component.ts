import { HttpClient } from '@angular/common/http';
import { Component, OnInit, OnChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { ConfigService } from 'src/app/config/config.service';
import { AuctionInCard } from 'src/app/shop-customer/services/shop-main/auction-in-card';
import { ShopAuctionListService } from 'src/app/shop-customer/services/shop-main/shop-auction-list/shop-auction-list.service';
import { AuctionForUserService } from 'src/app/shop-customer/services/shop-main/shop-auction/auction-for-user.service';
import { AbstractList } from 'src/app/shops-app/components/list/abstract-list';
import { ListInterface } from 'src/app/shops-app/components/list/list-interface';
import { AbstractListBase } from 'src/app/shops-app/components/list/abstract-list-base';

@Component({
  selector: 'app-shop-auctions-list',
  templateUrl: './shop-auctions-list.component.html',
  styleUrls: ['./shop-auctions-list.component.scss']
})
export class ShopAuctionsListComponent extends AbstractListBase implements OnInit, ListInterface {

  listData$: Observable<AbstractList<AuctionInCard>>;
  idCategory: number = 0;
  page: number = 0;
  basePath = this.route.snapshot.url[0].path;
  priceSort: string = "";
  dateSort: string = "";

  constructor(private http: HttpClient, private config: ConfigService, private shopAuctionListService: ShopAuctionListService,
    private auctionForUserService: AuctionForUserService, private route: ActivatedRoute, private router: Router) {
    super();
  }

  ngOnInit() {

    this.listData$ = this.route.paramMap.pipe(
      switchMap(params => {
        if (this.idCategory != +params.get('id_category')) {
          this.idCategory = +params.get('id_category');
          this.priceSort = "";
          this.dateSort = "";
        } else {
          this.priceSort = params.get(this.PRICE_SORT) || this.priceSort;
          this.dateSort = params.get(this.DATE_SORT) || this.dateSort;
        }
        this.page = +params.get('page');
        return this.shopAuctionListService.getAuctions(this.idCategory, this.page, this.priceSort, this.dateSort);
      })
    );
  }

  getBasePath(): string {
    return this.basePath + "/" + this.idCategory;
  }

  sortList(sortColumn: string) {
    switch (sortColumn) {
      case this.PRICE_SORT:
        this.priceSort = this.getNextSortType(this.priceSort);
        break;
      case this.DATE_SORT:
        this.dateSort = this.getNextSortType(this.dateSort);
        break;
    }
    this.router.navigate([`/list/${this.idCategory}/${this.page}`, { priceSort: this.priceSort, dateSort: this.dateSort }]);
  }

}

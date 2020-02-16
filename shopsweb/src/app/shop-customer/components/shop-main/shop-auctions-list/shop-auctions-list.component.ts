import { HttpClient } from '@angular/common/http';
import { Component, OnInit, AfterContentInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap, debounceTime } from 'rxjs/operators';
import { distinctUntilChanged } from 'rxjs/operators';
import { ConfigService } from 'src/app/config/config.service';
import { AuctionInCard } from 'src/app/shop-customer/services/shop-main/auction-in-card';
import { ShopAuctionListService } from 'src/app/shop-customer/services/shop-main/shop-auction-list/shop-auction-list.service';
import { AuctionForUserService } from 'src/app/shop-customer/services/shop-main/shop-auction/auction-for-user.service';
import { AbstractList } from 'src/app/shops-app/components/list/abstract-list';
import { ListInterface } from 'src/app/shops-app/components/list/list-interface';
import { AbstractListBase } from 'src/app/shops-app/components/list/abstract-list-base';
import { FormControl } from '@angular/forms';
import ShopsappUtils from 'src/app/shops-app/shopsapp-utils';
declare let $: any;

@Component({
  selector: 'app-shop-auctions-list',
  templateUrl: './shop-auctions-list.component.html',
  styleUrls: ['./shop-auctions-list.component.scss']
})
export class ShopAuctionsListComponent extends AbstractListBase implements OnInit, AfterContentInit, ListInterface {

  listData$: Observable<AbstractList<AuctionInCard>>;
  idCategory: number = 0;
  page: number = 0;
  basePath = this.route.snapshot.url[0].path;
  priceFromInput: FormControl;
  priceToInput: FormControl;
  dateFromInput: FormControl;
  dateToInput: FormControl;
  params = {};

  constructor(private http: HttpClient, private config: ConfigService, private shopAuctionListService: ShopAuctionListService,
    private auctionForUserService: AuctionForUserService, private route: ActivatedRoute, private router: Router) {
    super();
  }

  ngAfterContentInit(): void {
  }

  ngOnInit() {

    this.initFilters();

    this.listData$ = this.route.paramMap.pipe(
      switchMap(params => {
        if (this.idCategory != +params.get('id_category') && this.idCategory > 0) {
          this.params[this.PRICE_SORT] = "";
          this.params[this.DATE_SORT] = "";
          this.params[this.PRICE_FROM] = "";
          this.params[this.PRICE_TO] = "";
          this.params[this.DATE_FROM] = "";
          this.params[this.DATE_TO] = "";
        } else {
          this.params[this.PRICE_SORT] = params.get(this.PRICE_SORT) || this.params[this.PRICE_SORT] || "";
          this.params[this.DATE_SORT] = params.get(this.DATE_SORT) || this.params[this.DATE_SORT] || "";
          this.params[this.PRICE_FROM] = params.get(this.PRICE_FROM) || this.params[this.PRICE_FROM] || "";
          this.params[this.PRICE_TO] = params.get(this.PRICE_TO) || this.params[this.PRICE_TO] || "";
          this.params[this.DATE_FROM] = params.get(this.DATE_FROM) || this.params[this.DATE_FROM] || "";
          this.params[this.DATE_TO] = params.get(this.DATE_TO) || this.params[this.DATE_TO] || "";
        }
        this.idCategory = +params.get('id_category');
        this.page = +params.get('page');
        $("#priceFrom").val(this.params[this.PRICE_FROM]);
        $("#priceTo").val(this.params[this.PRICE_TO]);
        $("#dateFrom").val(this.params[this.DATE_FROM]);
        $("#dateTo").val(this.params[this.DATE_TO]);
        return this.shopAuctionListService.getAuctions(this.idCategory, this.page, ShopsappUtils.getObjectToUrl(this.params));
      })
    );

  }

  initFilters(): void {

    this.priceFromInput = new FormControl('');
    this.priceFromInput.valueChanges.pipe(debounceTime(500), distinctUntilChanged())
      .subscribe(value => {
        this.params[this.PRICE_FROM] = value != null ? value : "";
        this.router.navigate([`/list/${this.idCategory}/0`, this.params]);
      });

    this.priceToInput = new FormControl('');
    this.priceToInput.valueChanges.pipe(debounceTime(500), distinctUntilChanged())
      .subscribe(value => {
        this.params[this.PRICE_TO] = value != null ? value : "";
        this.router.navigate([`/list/${this.idCategory}/0`, this.params]);
      });

    this.dateFromInput = new FormControl('');
    this.dateFromInput.valueChanges.pipe(debounceTime(500), distinctUntilChanged())
      .subscribe(value => {
        this.filterDate("from", value);
      });

    this.dateToInput = new FormControl('');
    this.dateToInput.valueChanges.pipe(debounceTime(500), distinctUntilChanged())
      .subscribe(value => {
        this.filterDate("to", value);
      });

    $('#dateFrom').datepicker({
      dateFormat: this.config.dateFormat,
      onSelect: (selectedDate, inst) => {
        this.filterDate("from", selectedDate);
      }
    });

    $('#dateTo').datepicker({
      dateFormat: this.config.dateFormat,
      onSelect: (selectedDate, inst) => {
        this.filterDate("to", selectedDate);
      }
    });

  }

  filterDate(type: string, selectedDate: string): void {
    if (type == "from") {
      this.params[this.DATE_FROM] = selectedDate;
      this.router.navigate([`/list/${this.idCategory}/0`, this.params]);
    }
    if (type == "to") {
      this.params[this.DATE_TO] = selectedDate;
      this.router.navigate([`/list/${this.idCategory}/0`, this.params]);
    }
  }

  getBasePath(): string {
    return this.basePath + "/" + this.idCategory;
  }

  sortList(sortColumn: string) {
    switch (sortColumn) {
      case this.PRICE_SORT:
        this.params[this.PRICE_SORT] = this.getNextSortType(this.params[this.PRICE_SORT]);
        break;
      case this.DATE_SORT:
        this.params[this.DATE_SORT] = this.getNextSortType(this.params[this.DATE_SORT]);
        break;
    }
    this.router.navigate([`/list/${this.idCategory}/${this.page}`, this.params]);
  }

}

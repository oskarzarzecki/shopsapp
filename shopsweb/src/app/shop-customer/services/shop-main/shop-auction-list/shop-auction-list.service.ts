import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConfigService } from 'src/app/config/config.service';
import { Observable } from 'rxjs';
import { AuctionInCard } from '../auction-in-card';
import { tap } from 'rxjs/operators';
import { ProductBaseService } from 'src/app/shops-app/services/base-services/product-base.service';
import { AbstractList } from 'src/app/shops-app/components/list/abstract-list';

@Injectable({
  providedIn: 'root'
})
export class ShopAuctionListService {

  constructor(private http: HttpClient, private config: ConfigService, private productBaseService: ProductBaseService) { }

  getAuctions(idCategory: number, page: number, params: string): Observable<AbstractList<AuctionInCard>> {
    let apiURL = `${this.config.apiRoot}auctions/get-auctions-by-category/${idCategory}/${page}?${params}`;
    return this.http.get<AbstractList<AuctionInCard>>(apiURL)
      .pipe(
        tap(listData => {
          listData.items.forEach(auction => {
            auction.idImage = this.productBaseService.getProductImageLink(auction.idProduct, auction.idImage);
          });
        })
      );
  }
}

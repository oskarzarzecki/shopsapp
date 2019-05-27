import { Injectable } from '@angular/core';
import { ConfigService } from '../../../../config/config.service';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { AuctionInCard } from '../auction-in-card';
import { ProductBaseService } from 'src/app/shops-app/services/base-services/product-base.service';

@Injectable({
  providedIn: 'root'
})
export class PromotedAuctionService {

  constructor(private http: HttpClient, private config: ConfigService, private productBaseService: ProductBaseService) { }

  getPromotedAuctions(): Observable<AuctionInCard[]> {
    let apiURL = `${this.config.apiRoot}auctions/get-promoted-auctions`;
    return this.http.get<AuctionInCard[]>(apiURL)
      .pipe(
        tap(auctions => {
          console.log("fetched auctions");
          auctions.forEach(auction => {
            auction.idImage = this.productBaseService.getProductImageLink(auction.idProduct, auction.idImage);
          });
        })
      );
  }

  private handleErrorObservable(error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }

}

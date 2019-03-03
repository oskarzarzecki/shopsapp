import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConfigService } from 'src/app/config/config.service';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { PromotedAuction } from '../start-page/promoted-list/promoted-auction';

@Injectable({
  providedIn: 'root'
})
export class AuctionForUserService {

  constructor(private http: HttpClient, private config: ConfigService) { }

  getAuctionData(id: number): Observable<any> {
    let apiURL = `${this.config.apiRoot}auctions/get-auction-for-user/${id}`;
    return this.http.get<any>(apiURL)
      .pipe(
        tap(auctions => console.log("fetched auction"))
      );
  }

  getProductImageLink(idProduct: number, idProductImage: string): string {
    let apiURL = `${this.config.apiRoot}products/get-product-image?idProduct=${idProduct}&idProductImage=${idProductImage}`;
    return apiURL;
  }

}

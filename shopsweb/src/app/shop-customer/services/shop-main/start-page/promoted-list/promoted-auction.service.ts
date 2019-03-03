import { Injectable } from '@angular/core';
import { ConfigService } from '../../../../../config/config.service';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { PromotedAuction } from './promoted-auction';

@Injectable({
  providedIn: 'root'
})
export class PromotedAuctionService {

  constructor(private http: HttpClient, private config: ConfigService) { }

  getPromotedAuctions(): Observable<PromotedAuction[]> {
    let apiURL = `${this.config.apiRoot}auctions/get-promoted-auctions`;
    return this.http.get<PromotedAuction[]>(apiURL)
      .pipe(
        tap(auctions => console.log("fetched auctions"))
      );
  }

  private handleErrorObservable(error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }

}

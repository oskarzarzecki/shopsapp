import { Injectable } from '@angular/core';
import { ConfigService } from '../../../../config/config.service';
import { Observable } from 'rxjs';
import { map, tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PromotedProductsService {

  constructor(private http: HttpClient, private config: ConfigService) { }

  getPromotedAuctions(): Observable<any[]> {
    let apiURL = `${this.config.apiRoot}auctions/get-promoted-auctions`;
    return this.http.get<any[]>(apiURL)
    .pipe(
      tap(auctions => console.log("fetched auctions"))
    );
  }

}

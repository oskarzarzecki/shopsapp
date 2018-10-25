import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { ConfigService } from '../../../../config/config.service';
import { PromotedProduct } from './promoted-product/promoted-product';
import { Observable } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PromotedProductsServiceService {

  constructor(private http: Http, private config: ConfigService) { }

  getItems(): Observable<PromotedProduct[]> {
    let apiURL = `${this.config.apiRoot}?get-promoted-items`;
    return this.http.get(apiURL).pipe(
      tap(products => console.log('found items')),
      catchError(error => console.log(error))
    );
  }
  

}

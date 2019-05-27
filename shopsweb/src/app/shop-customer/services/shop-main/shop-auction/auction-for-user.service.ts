import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConfigService } from 'src/app/config/config.service';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { ProductBaseService } from 'src/app/shops-app/services/base-services/product-base.service';

@Injectable({
  providedIn: 'root'
})
export class AuctionForUserService {

  constructor(private http: HttpClient, private config: ConfigService, private productBaseService: ProductBaseService) { }

  getAuctionData(id: number): Observable<any> {
    let apiURL = `${this.config.apiRoot}auctions/get-auction-for-user/${id}`;
    return this.http.get<any>(apiURL)
      .pipe(
        tap(auctions => {
          console.log("fetched auction");
          let idProduct = auctions.product.id;
          auctions.product.productVariants[0].productImages.forEach(image => {
            image.idImage = this.productBaseService.getProductImageLink(idProduct, image.id);
          });
        })
      );
  }

}

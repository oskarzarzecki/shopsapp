import { Injectable } from '@angular/core';
import { ConfigService } from 'src/app/config/config.service';

@Injectable({
  providedIn: 'root'
})
export class ProductBaseService {

  constructor(private config: ConfigService) { }

  getProductImageLink(idProduct: number, idProductImage: string): string {
    let apiURL = `${this.config.apiRoot}products/get-product-image?idProduct=${idProduct}&idProductImage=${idProductImage}`;
    return apiURL;
  }
}

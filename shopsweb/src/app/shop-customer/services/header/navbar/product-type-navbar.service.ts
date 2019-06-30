import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConfigService } from 'src/app/config/config.service';
import { Observable } from 'rxjs';
import { ProductTypeNavbar } from './product-type-navbar';

@Injectable({
  providedIn: 'root'
})
export class ProductTypeNavbarService {

  constructor(private http: HttpClient, private config: ConfigService) { }

  getProductTypesNavbar(): Observable<ProductTypeNavbar[]> {
    let apiURL = `${this.config.apiRoot}product-types`;
    return this.http.get<ProductTypeNavbar[]>(apiURL)
      .pipe(
      );
  }

}

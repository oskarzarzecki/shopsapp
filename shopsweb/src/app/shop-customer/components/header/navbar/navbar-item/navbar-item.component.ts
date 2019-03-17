import { Component, OnInit, Input } from '@angular/core';
import { ProductTypeNavbar } from 'src/app/shop-customer/services/header/navbar/product-type-navbar';

@Component({
  selector: 'shops-app-header-navbar-item',
  templateUrl: './navbar-item.component.html',
  styleUrls: ['./navbar-item.component.scss']
})
export class NavbarItemComponent implements OnInit {

  @Input()
  productType: ProductTypeNavbar;

  constructor() { }

  ngOnInit() {
  }

}

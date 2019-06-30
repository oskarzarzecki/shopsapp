import { Component, OnInit, ViewChildren, QueryList, AfterViewInit } from '@angular/core';
import { NavbarItemComponent } from './navbar-item/navbar-item.component';
import { ProductTypeNavbarService } from 'src/app/shop-customer/services/header/navbar/product-type-navbar.service';
import { ProductTypeNavbar } from 'src/app/shop-customer/services/header/navbar/product-type-navbar';

@Component({
  selector: 'shops-app-header-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  productTypes: ProductTypeNavbar[];

  @ViewChildren(NavbarItemComponent)
  navbarItems: QueryList<NavbarItemComponent>;

  constructor(private promotedAuctionService: ProductTypeNavbarService) { }

  ngOnInit() {
    this.getItems();
  }

  getItems(): void {
    this.promotedAuctionService.getProductTypesNavbar().subscribe(
      result => {
        this.productTypes = result;
      }
    );
  }

}

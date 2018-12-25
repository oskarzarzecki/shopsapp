import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopCustomerRoutingModule } from './shop-customer-routing.module';
import { HeaderTopRightComponent } from './components/header/header-top-right/header-top-right.component';
import { ShopStartPageComponent } from './components/shop-main/shop-start-page/shop-start-page.component';
import { JumboComponent } from './components/shop-main/shop-start-page/jumbo/jumbo.component';
import { PromotedListComponent } from './components/shop-main/shop-start-page/promoted-list/promoted-list.component';
import { ShopAuctionComponent } from './components/shop-main/shop-auction/shop-auction.component';
import { ShopsAppModule } from '../shops-app/shops-app.module';
import { ShopCustomerComponent } from './components/shop-customer/shop-customer.component';
import { ShopMainComponent } from './components/shop-main/shop-main.component';
import { NavbarComponent } from './components/header/navbar/navbar.component';
import { ShopProductsListComponent } from './components/shop-main/shop-products-list/shop-products-list.component';
import { PromotedAuctionComponent } from './components/shop-main/shop-start-page/promoted-list/promoted-auction/promoted-auction.component';

/**
 * ShopCustomerModule - main shop website, module intended for making orders by customers
 */
@NgModule({
  imports: [
    CommonModule,
    ShopCustomerRoutingModule,
    ShopsAppModule
  ],
  declarations: [
    HeaderTopRightComponent,
    JumboComponent,
    PromotedListComponent,
    ShopStartPageComponent,
    ShopAuctionComponent,
    ShopCustomerComponent,
    ShopMainComponent,
    PromotedAuctionComponent,
    NavbarComponent,
    ShopProductsListComponent
  ]
})
export class ShopCustomerModule { }

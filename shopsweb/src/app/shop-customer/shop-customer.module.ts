import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopCustomerRoutingModule } from './shop-customer-routing.module';
import { HeaderTopRightComponent } from './header/header-top-right/header-top-right.component';
import { ShopMainSiteComponent } from './shop-main/shop-main-site/shop-main-site.component';
import { JumboComponent } from './shop-main/shop-main-site/jumbo/jumbo.component';
import { PromotedListComponent } from './shop-main/shop-main-site/promoted-list/promoted-list.component';
import { PromotedProductComponent } from './shop-main/shop-main-site/promoted-list/promoted-product/promoted-product.component';
import { ShopAuctionComponent } from './shop-main/shop-auction/shop-auction.component';

/**
 * ShopCustomerModule - main shop website, module intended for making orders by customers
 */
@NgModule({
  imports: [
    CommonModule,
    ShopCustomerRoutingModule
  ],
  declarations: [
    HeaderTopRightComponent,
    JumboComponent,
    PromotedListComponent,
    PromotedProductComponent,
    ShopMainSiteComponent,
    ShopAuctionComponent
  ]
})
export class ShopCustomerModule { }

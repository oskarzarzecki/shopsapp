import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopCustomerRoutingModule } from './shop-customer-routing.module';
import { HeaderTopRightComponent } from './header/header-top-right/header-top-right.component';
import { JumboComponent } from './jumbo/jumbo.component';
import { PromotedListComponent } from './promoted-list/promoted-list.component';
import { PromotedProductComponent } from './promoted-list/promoted-product/promoted-product.component';
import { ShopMainSiteComponent } from './shop-main-site/shop-main-site.component';

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
    ShopMainSiteComponent
  ]
})
export class ShopCustomerModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopCustomerRoutingModule } from './shop-customer-routing.module';
import { HeaderTopRightLoginComponent } from './components/header/header-top-right/header-top-right-login/header-top-right-login.component';
import { ShopStartPageComponent } from './components/shop-main/shop-start-page/shop-start-page.component';
import { JumboComponent } from './components/shop-main/shop-start-page/jumbo/jumbo.component';
import { PromotedListComponent } from './components/shop-main/shop-start-page/promoted-list/promoted-list.component';
import { ShopAuctionComponent } from './components/shop-main/shop-auction/shop-auction.component';
import { ShopsAppModule } from '../shops-app/shops-app.module';
import { ShopCustomerComponent } from './components/shop-customer/shop-customer.component';
import { ShopMainComponent } from './components/shop-main/shop-main.component';
import { NavbarComponent } from './components/header/navbar/navbar.component';
import { NavbarItemComponent } from './components/header/navbar/navbar-item/navbar-item.component';
import { ShopAuctionsListComponent } from './components/shop-main/shop-auctions-list/shop-auctions-list.component';
import { AuctionCardComponent } from './components/shared/auction-card/auction-card.component';
import { ShopMainLargeComponent } from './components/shop-main-large/shop-main-large.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ShopRegisterComponent } from './components/shop-main/shop-register/shop-register.component';
import { HeaderTopRightLoggedUserComponent } from './components/header/header-top-right/header-top-right-logged-user/header-top-right-logged-user.component';
import { ShopAddressEditComponent } from './components/shop-main/shop-address-edit/shop-address-edit.component';

/**
 * ShopCustomerModule - main shop website, module intended for making orders by customers
 */
@NgModule({
  imports: [
    CommonModule,
    ShopCustomerRoutingModule,
    ShopsAppModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
    HeaderTopRightLoginComponent,
    JumboComponent,
    PromotedListComponent,
    ShopStartPageComponent,
    ShopAuctionComponent,
    ShopCustomerComponent,
    ShopMainComponent,
    NavbarComponent,
    ShopAuctionsListComponent,
    NavbarItemComponent,
    AuctionCardComponent,
    ShopMainLargeComponent,
    ShopRegisterComponent,
    HeaderTopRightLoggedUserComponent,
    ShopAddressEditComponent
  ]
})
export class ShopCustomerModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShopCustomerComponent } from './components/shop-customer/shop-customer.component';
import { ShopMainComponent } from './components/shop-main/shop-main.component';
import { ShopStartPageComponent } from './components/shop-main/shop-start-page/shop-start-page.component';
import { ShopAuctionComponent } from './components/shop-main/shop-auction/shop-auction.component';
import { ShopAuctionsListComponent } from './components/shop-main/shop-auctions-list/shop-auctions-list.component';
import { ShopMainLargeComponent } from './components/shop-main-large/shop-main-large.component';
import { ShopRegisterComponent } from './components/shop-main/shop-register/shop-register.component';
import { ShopAddressEditComponent } from './components/shop-main/shop-address-edit/shop-address-edit.component';
import { CustomerAuthGuardService } from './services/guards/customer-auth-guard.service';

const routes: Routes = [
  {
    path: '',
    component: ShopCustomerComponent,
    children: [
      {
        path: '',
        component: ShopMainComponent,
        children: [
          { path: '', component: ShopStartPageComponent },
          { path: 'auction/:id', component: ShopAuctionComponent },
          { path: 'register', component: ShopRegisterComponent },
          { path: 'address-edit', component: ShopAddressEditComponent, canActivate: [CustomerAuthGuardService] },
        ]
      },
      {
        path: '',
        component: ShopMainLargeComponent,
        children: [
          { path: 'list/:id_category/:page', component: ShopAuctionsListComponent },
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShopCustomerRoutingModule { }

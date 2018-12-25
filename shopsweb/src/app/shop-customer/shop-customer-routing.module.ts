import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShopCustomerComponent } from './components/shop-customer/shop-customer.component';
import { ShopMainComponent } from './components/shop-main/shop-main.component';
import { ShopStartPageComponent } from './components/shop-main/shop-start-page/shop-start-page.component';
import { ShopAuctionComponent } from './components/shop-main/shop-auction/shop-auction.component';
import { ShopProductsListComponent } from './components/shop-main/shop-products-list/shop-products-list.component';

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
          { path: 'list/:id', component: ShopProductsListComponent },
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

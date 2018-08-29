import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: 'app/shop-customer/shop-customer.module#ShopCustomerModule'
  },
  {
    path: 'management',
    loadChildren: 'app/shop-management/shop-management.module#ShopManagementModule'
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }

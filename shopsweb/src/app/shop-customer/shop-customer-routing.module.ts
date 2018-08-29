import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderTopRightComponent } from './header/header-top-right/header-top-right.component';
import { ShopMainSiteComponent } from './shop-main-site/shop-main-site.component';

const routes: Routes = [
  {
    path: '',
    component: HeaderTopRightComponent,
    outlet: 'header-top-right'
  },
  {
    path: '',
    component: ShopMainSiteComponent,
    outlet: 'main-site-content'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShopCustomerRoutingModule { }

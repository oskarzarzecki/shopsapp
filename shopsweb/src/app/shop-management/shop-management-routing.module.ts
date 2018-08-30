import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShopManagementLoginComponent } from './shop-management-login/shop-management-login.component';
import { HeaderTopRightComponent } from './header/header-top-right/header-top-right.component';

const routes: Routes = [
  {
    path: '',
    component: HeaderTopRightComponent,
    outlet: 'header-top-right'
  },
  {
    path: '',
    component: ShopManagementLoginComponent,
    outlet: 'main-site-content'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShopManagementRoutingModule { }

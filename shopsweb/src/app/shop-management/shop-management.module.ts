import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopManagementRoutingModule } from './shop-management-routing.module';
import { ShopManagementLoginComponent } from './shop-management-login/shop-management-login.component';
import { HeaderTopRightComponent } from './header/header-top-right/header-top-right.component';

/**
 * ShopManagementModule - module intended for managing customer orders,
 * and website content
 */
@NgModule({
  imports: [
    CommonModule,
    ShopManagementRoutingModule
  ],
  declarations: [
    ShopManagementLoginComponent,
    HeaderTopRightComponent
  ]
})
export class ShopManagementModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopManagementRoutingModule } from './shop-management-routing.module';
import { ShopManagementLoginComponent } from './shop-management-login/shop-management-login.component';
import { HeaderTopRightComponent } from './header/header-top-right/header-top-right.component';
import { ShopsAppModule } from '../shops-app/shops-app.module';
import { ShopManagementComponent } from './components/shop-management/shop-management.component';
import { ManagementMainComponent } from './components/management-main/management-main.component';

/**
 * ShopManagementModule - module intended for managing customer orders,
 * and website content
 */
@NgModule({
  imports: [
    CommonModule,
    ShopManagementRoutingModule,
    ShopsAppModule
  ],
  declarations: [
    ShopManagementLoginComponent,
    HeaderTopRightComponent,
    ShopManagementComponent,
    ManagementMainComponent
  ]
})
export class ShopManagementModule { }

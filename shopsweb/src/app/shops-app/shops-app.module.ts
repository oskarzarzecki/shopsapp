import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShopsAppHeaderComponent } from './shops-app-header/shops-app-header.component';
import { ShopsAppMainComponent } from './shops-app-main/shops-app-main.component';
import { ShopsAppFooterComponent } from './shops-app-footer/shops-app-footer.component';
import { AppRoutingModule } from '../app-routing.module';

/**
 * ShopsAppModule - module containing shared components and services,
 * used in whole application.
 */
@NgModule({
  imports: [
    CommonModule,
    AppRoutingModule
  ],
  declarations: [
    ShopsAppHeaderComponent,
    ShopsAppMainComponent,
    ShopsAppFooterComponent
  ],
  exports: [
    CommonModule,
    ShopsAppHeaderComponent,
    ShopsAppMainComponent,
    ShopsAppFooterComponent
  ]
})
export class ShopsAppModule { }

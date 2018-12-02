import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShopsAppHeaderComponent } from './components/application/shops-app-header/shops-app-header.component';
import { ShopsAppMainComponent } from './components/application/shops-app-main/shops-app-main.component';
import { ShopsAppFooterComponent } from './components/application/shops-app-footer/shops-app-footer.component';
import { ProductAuctionComponent } from './components/auctions/product-auction/product-auction.component';
import { RouterModule } from '@angular/router';

/**
 * ShopsAppModule - module containing shared components and services,
 * used in whole application.
 */
@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  declarations: [
    ShopsAppHeaderComponent,
    ShopsAppMainComponent,
    ShopsAppFooterComponent,
    ProductAuctionComponent
  ],
  exports: [
    CommonModule,
    ShopsAppHeaderComponent,
    ShopsAppMainComponent,
    ShopsAppFooterComponent,
    ProductAuctionComponent
  ]
})
export class ShopsAppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { ShopHeaderComponent } from './shop-header/shop-header.component';
import { ShopMainComponent } from './shop-main/shop-main.component';
import { JumboComponent } from './shop-main/jumbo/jumbo.component';
import { PromotedListComponent } from './shop-main/promoted-list/promoted-list.component';
import { ShopFooterComponent } from './shop-footer/shop-footer.component';
import { PromotedProductComponent } from './shop-main/promoted-list/promoted-product/promoted-product.component';


@NgModule({
  declarations: [
    AppComponent,
    ShopHeaderComponent,
    ShopMainComponent,
    JumboComponent,
    PromotedListComponent,
    ShopFooterComponent,
    PromotedProductComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

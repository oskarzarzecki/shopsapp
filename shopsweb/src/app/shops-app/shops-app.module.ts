import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShopsAppHeaderComponent } from './components/application/shops-app-header/shops-app-header.component';
import { ShopsAppFooterComponent } from './components/application/shops-app-footer/shops-app-footer.component';
import { RouterModule } from '@angular/router';
import { ShopsAppLogoComponent } from './components/application/shops-app-header/shops-app-logo/shops-app-logo.component';
import { PaginationComponent } from './components/list/pagination/pagination.component';
import { AbstractListComponent } from './components/list/abstract-list/abstract-list.component';

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
    ShopsAppFooterComponent,
    ShopsAppLogoComponent,
    PaginationComponent,
    AbstractListComponent
  ],
  exports: [
    CommonModule,
    ShopsAppHeaderComponent,
    ShopsAppFooterComponent,
    ShopsAppLogoComponent,
    PaginationComponent,
    AbstractListComponent
  ]
})
export class ShopsAppModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShopManagementComponent } from './components/shop-management/shop-management.component';
import { ManagementMainComponent } from './components/management-main/management-main.component';

const routes: Routes = [
  {
    path: '',
    component: ShopManagementComponent,
    children: [
      {
        path: '',
        component: ManagementMainComponent,
        children: [
        ]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShopManagementRoutingModule { }

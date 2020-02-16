import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ShopsAppModule } from './shops-app/shops-app.module';
import { ConfigService } from './config/config.service';
import { AuthHtppInterceptorService } from './shops-app/services/interceptors/auth-htpp-interceptor.service';
import { ErrorHtppInterceptorService } from './shops-app/services/interceptors/error-htpp-interceptor.service';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ShopsAppModule,
    HttpClientModule
  ],
  providers: [ConfigService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthHtppInterceptorService, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorHtppInterceptorService, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

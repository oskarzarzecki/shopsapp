import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { CustomerAuthenticationService } from '../security/customer-authentication.service';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerAuthGuardService implements CanActivate {

  constructor(private router: Router, private authService: CustomerAuthenticationService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
    return this.authService.authorize().pipe(
      map(status => {
        if (status) {
          return true;
        } else {
          return false;
        }
      }),
      catchError((err) => {
        localStorage.setItem('username', '');
        localStorage.setItem('token', '');
        this.router.navigate(['/']);
        return of(false);
      })
    );
  }


}

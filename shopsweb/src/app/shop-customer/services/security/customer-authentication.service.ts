import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';
import { ConfigService } from 'src/app/config/config.service';
import { Observable, throwError } from 'rxjs';
import { LoggedCustomer } from './logged-customer';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CustomerAuthenticationService {

  constructor(private httpClient: HttpClient, private config: ConfigService, private router: Router) { }

  authenticate(username, password): Observable<LoggedCustomer> {
    let apiURL = `${this.config.apiRoot}customer-auth/authenticate`;
    return this.httpClient.post<any>(apiURL, { username, password }).pipe(
      map(
        userData => {
          localStorage.setItem('username', username);
          let token = 'Bearer ' + userData.jwtToken;
          localStorage.setItem('token', token);
          return userData;
        }
      )
    );
  }

  logout() {
    let apiURL = `${this.config.apiRoot}logout`;
    return this.httpClient.post<any>(apiURL, {}).pipe(
      map(
        userData => {
          localStorage.setItem('username', '');
          localStorage.setItem('token', '');
          return userData;
        }
      )
    );
  }

  authorize(): Observable<boolean> {
    let apiURL = `${this.config.apiRoot}customer-auth/authorize`;
    return this.httpClient.post<any>(apiURL, { param: 1 }).pipe(
      // catchError(this.handleError),
      map(
        status => {
          return status;
        }
      )
    );
  }

  handleError(error) {
    return throwError(error);
  }

  register(username, password): Observable<boolean> {
    let apiURL = `${this.config.apiRoot}customer-auth/register`;
    return this.httpClient.post<any>(apiURL, { username, password }).pipe(
      map(
        status => {
          return status;
        }
      )
    );
  }

  validateUniqueEmail(email): Observable<boolean> {
    let apiURL = `${this.config.apiRoot}customer-auth/validate-unique-email`;
    return this.httpClient.post<any>(apiURL, email).pipe(
      // catchError(this.handleError),
      map(
        status => {
          return status;
        }
      )
    );
  }

}

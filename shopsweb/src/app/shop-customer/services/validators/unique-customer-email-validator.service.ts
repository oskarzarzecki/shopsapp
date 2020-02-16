import { Injectable } from '@angular/core';
import { AsyncValidator, AbstractControl, ValidationErrors } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { CustomerAuthenticationService } from '../security/customer-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UniqueCustomerEmailValidator implements AsyncValidator {
  constructor(private authenticationService: CustomerAuthenticationService) { }

  validate(ctrl: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> {
    return this.authenticationService.validateUniqueEmail(ctrl.value).pipe(
      map(isTaken => (isTaken ? { uniqueCustomerEmail: true } : null)),
      catchError(() => null)
    );
  }
}

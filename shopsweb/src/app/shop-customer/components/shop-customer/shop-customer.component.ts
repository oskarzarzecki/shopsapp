import { Component, OnInit } from '@angular/core';
import { CustomerAuthenticationService } from '../../services/security/customer-authentication.service';
import { LoggedCustomer } from '../../services/security/logged-customer';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
declare let $: any;

@Component({
  selector: 'app-shop-customer',
  templateUrl: './shop-customer.component.html',
  styleUrls: ['./shop-customer.component.scss']
})
export class ShopCustomerComponent implements OnInit {

  private ERROR_EMPTY_LOGIN_DATA: string = "Please enter your email and password.";
  private ERROR_WRONG_LOGIN_DATA: string = "Invalid username or password.";
  private ERROR_SYSTEM: string = "A system error has occurred.";

  loggedCustomer: LoggedCustomer = new LoggedCustomer();
  authenticated: boolean = false;

  constructor(private router: Router, private auth: CustomerAuthenticationService) { }

  ngOnInit() {
    console.log("INIT:ShopCustomerComponent");
    this.authorize();
  }

  authenticate() {
    if (!this.validateLogin()) {
      return;
    }
    this.auth.authenticate($("#login-input").val(), $("#password-input").val()).subscribe(
      data => {
        this.loggedCustomer = data;
      },
      error => {
        console.log(error);
        $("#login-input").addClass("is-invalid");
        $("#password-input").addClass("is-invalid");
        if (error.status == 403) {
          $("#login-error").text(this.ERROR_WRONG_LOGIN_DATA);
          $("#login-error").show();
        } else {
          $("#login-error").text(this.ERROR_SYSTEM);
          $("#login-error").show();
        }
      }
    );
  }

  logout() {
    this.auth.logout().subscribe(
      data => {
        this.loggedCustomer = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  authorize() {
    this.loggedCustomer.email = localStorage.getItem("username");
    this.loggedCustomer.jwtToken = localStorage.getItem("token");
    if (this.isLogged()) {
      this.auth.authorize().subscribe(
        data => {

        },
        error => {
          this.loggedCustomer.email = "";
          this.loggedCustomer.jwtToken = "";
          localStorage.setItem('username', '');
          localStorage.setItem('token', '');
          this.router.navigate(['/']);
        }
      );
    }
  }

  isLogged(): boolean {
    return this.loggedCustomer.email != null && this.loggedCustomer.email != '' && this.loggedCustomer.jwtToken != null && this.loggedCustomer.jwtToken != '';
  }

  validateLogin(): boolean {
    $("#login-input").removeClass("is-invalid");
    $("#password-input").removeClass("is-invalid");
    $("#login-error").hide();
    if ($("#login-input").val() == undefined || !$("#login-input").val().trim()) {
      $("#login-input").addClass("is-invalid");
      $("#login-error").text(this.ERROR_EMPTY_LOGIN_DATA);
      $("#login-error").show();
      return false;
    }
    if ($("#password-input").val() == undefined || !$("#password-input").val().trim()) {
      $("#password-input").addClass("is-invalid");
      $("#login-error").text(this.ERROR_EMPTY_LOGIN_DATA);
      $("#login-error").show();
      return false;
    }
    return true;
  }

}

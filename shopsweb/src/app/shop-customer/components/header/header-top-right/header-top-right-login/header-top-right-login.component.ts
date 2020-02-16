import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { CustomerAuthenticationService } from 'src/app/shop-customer/services/security/customer-authentication.service';
import { Router } from '@angular/router';
declare let $: any;

@Component({
  selector: 'shops-app-header-top-right-login',
  templateUrl: './header-top-right-login.component.html',
  styleUrls: ['./header-top-right-login.component.scss'],
  host: {
    'class': ''
  }
})
export class HeaderTopRightLoginComponent implements OnInit {

  @Output() authEvent = new EventEmitter<string>();

  authenticate() {
    this.authEvent.next('authEvent');
  }

  constructor() { }

  ngOnInit() {
    $('#login-button').popover({
      html: true,
      content: `
      <div id="login_popover_content_wrapper"><div class="container">
        <input id="login-input" type="text" class="col form-control mt-2" id="login-input" placeholder="Email" required>
        <input id="password-input" type="password" class="col form-control mt-2" placeholder="Password" required>
        <div id="login-error" class="invalid-feedback">
          Please provide a valid city.
        </div>
        <button onclick="$('#hidden-auth-btn').click();" id="authenticate" class="col btn btn-success mt-2 mb-2">
          <i class="fa-sign-in fa fa-1x"></i>Sign in</button>
        </div>
      </div>`,
      container: 'shops-app-header-top-right-login'
    });

  }

}

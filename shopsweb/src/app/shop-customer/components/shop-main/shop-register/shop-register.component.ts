import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { UniqueCustomerEmailValidator } from 'src/app/shop-customer/services/validators/unique-customer-email-validator.service';
import { CustomerAuthenticationService } from 'src/app/shop-customer/services/security/customer-authentication.service';
declare let $: any;

@Component({
  selector: 'app-shop-register',
  templateUrl: './shop-register.component.html',
  styleUrls: ['./shop-register.component.scss']
})
export class ShopRegisterComponent implements OnInit {

  registerForm: FormGroup;
  termsHidden: boolean = true;
  privacyHidden: boolean = true;

  constructor(private authenticationService: CustomerAuthenticationService, private uniqueEmailValidator: UniqueCustomerEmailValidator) { }

  ngOnInit() {
    this.initTerms();
    this.initForm();
  }

  initForm(): void {
    this.registerForm = new FormGroup({
      'email': new FormControl("", {
        validators: Validators.compose([
          Validators.required,
          Validators.email,
          Validators.minLength(5),
          Validators.maxLength(100)
        ]),
        asyncValidators: [this.uniqueEmailValidator.validate.bind(this.uniqueEmailValidator)],
        updateOn: "blur"
      }),
      'password': new FormControl("", {
        validators: Validators.compose([
          Validators.required,
          Validators.minLength(8),
          Validators.maxLength(200)
        ]),
        updateOn: "blur"
      }),
      'terms': new FormControl(false, {
        validators: Validators.compose([
          Validators.requiredTrue
        ]),
        updateOn: "change"
      })
    });
  }

  initTerms(): void {
    $("#terms-button").click(function () {
      if (this.termsHidden)
        $("#terms-text").hide("fold", 500);
      else
        $("#terms-text").show("fold", 500);
      this.termsHidden = !this.termsHidden;
    });
    $("#privacy-button").click(function () {
      if (this.privacyHidden)
        $("#privacy-text").hide("fold", 500);
      else
        $("#privacy-text").show("fold", 500);
      this.privacyHidden = !this.privacyHidden;
    });
  }

  onSubmit() {
    this.authenticationService.register(this.registerForm.get("email").value, this.registerForm.get("password").value).subscribe(
      status => {
        this.showSuccessPage(this.registerForm.get("email").value)
      }
    );
  }

  showSuccessPage(username: string) {
    $("#register-form").html("");
    $("#email-text").html(username);
    $("#success-message").show();
  }

}

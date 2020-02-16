import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'shops-app-header-top-right-logged-user',
  templateUrl: './header-top-right-logged-user.component.html',
  styleUrls: ['./header-top-right-logged-user.component.scss']
})
export class HeaderTopRightLoggedUserComponent implements OnInit {

  @Input() email: string = null;

  @Output() logoutEvent = new EventEmitter<string>();

  logout() {
    this.logoutEvent.next('logoutEvent');
  }

  constructor() { }

  ngOnInit() {
  }

}

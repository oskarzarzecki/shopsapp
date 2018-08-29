import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header-top-right',
  templateUrl: './header-top-right.component.html',
  styleUrls: ['./header-top-right.component.scss'],
  host: {
    'class': 'col-md-4 d-flex justify-content-end align-items-center mt-3 mt-md-0'
  }
})
export class HeaderTopRightComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

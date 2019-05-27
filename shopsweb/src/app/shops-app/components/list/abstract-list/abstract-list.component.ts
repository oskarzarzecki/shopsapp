import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-abstract-list',
  templateUrl: './abstract-list.component.html',
  styleUrls: ['./abstract-list.component.scss']
})
export class AbstractListComponent implements OnInit {

  basePath = this.route.snapshot.url[0].path + "";

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    
  }

}

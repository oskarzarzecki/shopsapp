import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { PaginationData } from '../pagination-data';
import { Observable, BehaviorSubject } from 'rxjs';
import ShopsappUtils from 'src/app/shops-app/shopsapp-utils';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.scss']
})
export class PaginationComponent implements OnInit, OnChanges {

  @Input() paginationData: PaginationData;
  @Input() currentPage: number = 0;
  @Input() basePath: string = null;
  pagesCount$: BehaviorSubject<number>;
  pagesArray$: Observable<number[]>;
  params: any = {};

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.url.subscribe(urlSegments => {
      this.params = urlSegments[urlSegments.length - 1].parameters;
      return urlSegments;
    });
  }

  ngOnChanges() {
    if (this.paginationData != null) {
      this.pagesCount$ = this.getPagesCount();
      let pagesArray = this.getPagesArray();
      let bSubject = new BehaviorSubject(pagesArray);
      this.pagesArray$ = bSubject.asObservable();
      if (this.currentPage > this.pagesCount$.getValue()) {
        this.router.navigate([this.basePath + "/0"]);
      }
    }
  }

  getPagesCount(): BehaviorSubject<number> {
    let bSubject = new BehaviorSubject(Math.floor((this.paginationData.itemsCount + this.paginationData.pageSize - 1) / this.paginationData.pageSize));
    return bSubject;
  }

  getPagesArray() {
    let start = (this.currentPage - this.paginationData.adjacentPages) <= 0 ? 0 : this.currentPage - this.paginationData.adjacentPages;
    let end = (this.currentPage + this.paginationData.adjacentPages) >= this.pagesCount$.getValue() ? (this.pagesCount$.getValue() - 1) : this.currentPage + this.paginationData.adjacentPages;
    return ShopsappUtils.getRangeArray(start, end);
  }

}

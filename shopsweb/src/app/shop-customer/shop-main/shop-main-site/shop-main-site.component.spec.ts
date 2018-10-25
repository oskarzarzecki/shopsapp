import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopMainSiteComponent } from './shop-main-site.component';

describe('ShopMainComponent', () => {
  let component: ShopMainSiteComponent;
  let fixture: ComponentFixture<ShopMainSiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopMainSiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopMainSiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

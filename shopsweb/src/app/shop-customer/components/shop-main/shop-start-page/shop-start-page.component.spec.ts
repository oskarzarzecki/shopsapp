import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopStartPageComponent } from './shop-start-page.component';

describe('ShopMainComponent', () => {
  let component: ShopStartPageComponent;
  let fixture: ComponentFixture<ShopStartPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopStartPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopStartPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

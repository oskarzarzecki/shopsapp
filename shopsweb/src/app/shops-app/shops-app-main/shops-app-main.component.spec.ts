import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopsAppMainComponent } from './shops-app-main.component';

describe('ShopMainComponent', () => {
  let component: ShopsAppMainComponent;
  let fixture: ComponentFixture<ShopsAppMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopsAppMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopsAppMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

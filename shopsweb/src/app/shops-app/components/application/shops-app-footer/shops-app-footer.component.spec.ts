import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopsAppFooterComponent } from './shops-app-footer.component';

describe('ShopFooterComponent', () => {
  let component: ShopsAppFooterComponent;
  let fixture: ComponentFixture<ShopsAppFooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopsAppFooterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopsAppFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

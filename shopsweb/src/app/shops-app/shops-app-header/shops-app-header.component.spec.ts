import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopsAppHeaderComponent } from './shops-app-header.component';

describe('ShopHeaderComponent', () => {
  let component: ShopsAppHeaderComponent;
  let fixture: ComponentFixture<ShopsAppHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopsAppHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopsAppHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

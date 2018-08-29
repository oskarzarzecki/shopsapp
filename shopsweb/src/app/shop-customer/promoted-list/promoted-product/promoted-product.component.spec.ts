import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PromotedProductComponent } from './promoted-product.component';

describe('PromotedProductComponent', () => {
  let component: PromotedProductComponent;
  let fixture: ComponentFixture<PromotedProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PromotedProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PromotedProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

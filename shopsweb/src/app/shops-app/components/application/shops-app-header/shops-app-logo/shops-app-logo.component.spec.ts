import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopsAppLogoComponent } from './shops-app-logo.component';

describe('ShopsAppLogoComponent', () => {
  let component: ShopsAppLogoComponent;
  let fixture: ComponentFixture<ShopsAppLogoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopsAppLogoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopsAppLogoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

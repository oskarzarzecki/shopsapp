import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderTopRightLoginComponent } from './header-top-right-login.component';

describe('HeaderTopRightComponent', () => {
  let component: HeaderTopRightLoginComponent;
  let fixture: ComponentFixture<HeaderTopRightLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderTopRightLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderTopRightLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

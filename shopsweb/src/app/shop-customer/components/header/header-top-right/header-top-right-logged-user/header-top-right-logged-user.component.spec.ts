import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderTopRightLoggedUserComponent } from './header-top-right-logged-user.component';

describe('HeaderTopRightLoggedUserComponent', () => {
  let component: HeaderTopRightLoggedUserComponent;
  let fixture: ComponentFixture<HeaderTopRightLoggedUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderTopRightLoggedUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderTopRightLoggedUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

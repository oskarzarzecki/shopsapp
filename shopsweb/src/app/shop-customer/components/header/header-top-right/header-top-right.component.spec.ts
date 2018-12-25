import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderTopRightComponent } from './header-top-right.component';

describe('HeaderTopRightComponent', () => {
  let component: HeaderTopRightComponent;
  let fixture: ComponentFixture<HeaderTopRightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderTopRightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderTopRightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

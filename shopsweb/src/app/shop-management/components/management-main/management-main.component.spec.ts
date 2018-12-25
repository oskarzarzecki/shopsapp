import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagementMainComponent } from './management-main.component';

describe('ManagementMainComponent', () => {
  let component: ManagementMainComponent;
  let fixture: ComponentFixture<ManagementMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagementMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagementMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

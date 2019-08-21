import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  public apiRoot: string = environment.apiRoot;

  public currency: string = environment.currency;
  
  public dateFormat: string = environment.dateFormat;

  constructor() { }
}

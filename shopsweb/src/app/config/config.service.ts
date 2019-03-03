import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  public apiRoot: string = 'http://localhost:4200/api/';

  public currency: string = 'zł';

  constructor() { }
}

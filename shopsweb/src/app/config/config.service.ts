import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  apiRoot: string = 'http://localhost:8080/';

  constructor() { }
}

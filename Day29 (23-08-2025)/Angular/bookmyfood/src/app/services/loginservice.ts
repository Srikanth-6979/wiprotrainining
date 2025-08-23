import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from '../interfaces/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  
  private apiUrl = 'http://localhost:9000/user/login'; 

  constructor(private http: HttpClient) {}

  login(loginData: Login): Observable<any> {
    return this.http.post(this.apiUrl, loginData);
  }
}

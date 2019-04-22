import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Login } from '../interfaces/login';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  public login(login: Login): Observable<any> {
    return this.http.post('http://localhost:8080/login', login, { observe: 'response' as 'body' });
  }
}

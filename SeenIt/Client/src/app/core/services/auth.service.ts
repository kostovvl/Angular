import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly register_url = 'http://localhost:8080/auth/register';
  private readonly signin_url = 'http://localhost:8080/auth/login'

  constructor(
    private http: HttpClient
  ) { }


  get token() {
    return localStorage.getItem('token');
  }

  signUp(body: Object) {
    return this.http.post(this.register_url, body);
  }

  signIn(body: Object) {
    return this.http.post(this.signin_url, body);
  }

  logout() {
    localStorage.clear();
    // return this.http.post(`${this.BASE_URL}/_logout`);
  }

  isAuthenticated() {
    return this.token !== null;
  }

  saveUserInfo(res: Object) {
    localStorage.setItem('username', res['user']);
    localStorage.setItem('roles', res['roles'])
    localStorage.setItem('token', res['token']);
    localStorage.setItem('userId', res['id']);
  }
}

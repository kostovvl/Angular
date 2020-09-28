import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const SIGN_UP_URL = 'http://localhost:8080/auth/register';
const SIGN_IN_URL = 'http://localhost:8080/auth/login'

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }


  get token() {
    return localStorage.getItem('token');
  }

  signUp(body: Object) {
    return this.http.post(SIGN_UP_URL, body);
  }

  signIn(body: Object) {
    return this.http.post(SIGN_IN_URL, body).subscribe((data) => {
      this.saveUserInfo(data);
    });
  }

  logout() {
    localStorage.clear();
    // return this.http.post(`${this.BASE_URL}/_logout`, {}, {
    //   headers: new HttpHeaders({
    //     'Authorization': `Kinvey ${this.token}`
    //   })
    // });
  }

  isAuthenticated() {
    return this.token !== null;
  }

  saveUserInfo(res: Object) {
    localStorage.setItem('username', res['user']);
    localStorage.setItem('userId', res['id']);
    localStorage.setItem('roles', res['roles'])
    localStorage.setItem('token', res['token']);
  }
}

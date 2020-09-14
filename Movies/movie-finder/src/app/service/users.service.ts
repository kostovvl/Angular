import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const REGISTER_URL = 'http://localhost:8080/users/register'

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }

  register(form) {
    let resulrt$ = this.http.post<any>(REGISTER_URL, form.value);
    return resulrt$;
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const REGISTER_URL = 'http://localhost:8080/register'

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  form;

  constructor(private http: HttpClient) { }

  register(form) {
    return this.http.post(REGISTER_URL, JSON.stringify(form))
  }

}

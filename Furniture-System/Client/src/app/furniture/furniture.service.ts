import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Furniture from './model.furniture';

const submit_url = 'http://localhost:8080/furniture/create';
const all_url = 'http://localhost:8080/furniture/all';
const details_url = 'http://localhost:8080/furniture/details/';
const mine_url = 'http://localhost:8080/furniture/mine';
const delete_url = 'http://localhost:8080/furniture/delete/';
const delete_admin_url = 'http://localhost:8080/admin/delete/';

@Injectable({
  providedIn: 'root'
})
export class FurnitureService {

  constructor(private http: HttpClient) { }

  submit(form) : Observable<any> {
   return this.http.post<any>(submit_url, form);
  }

  all() : Observable<any> {
    return this.http.get<any>(all_url);
  }

  details(id: number): Observable<Furniture> {
    return this.http.get<Furniture>(details_url + id)
  }

  mine() : Observable<any> {
    return this.http.get<any>(mine_url);
  }

  delete(id: number, username: string) : Observable<any> {
    return this.http.delete<any>(delete_url + id + '/' + username);
  }

  deleteAdmin(id: number) : Observable<any> {
    return this.http.delete<any>(delete_admin_url + id);
  }
}

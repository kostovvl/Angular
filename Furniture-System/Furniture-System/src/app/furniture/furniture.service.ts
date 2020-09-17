import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Furniture from './furniture.model';

const create_url = 'http://localhost:8080/furniture/create'
const all_url = 'http://localhost:8080/furniture/all'
const details_url = 'http://localhost:8080/furniture/details/'
const my_furniture_url = 'http://localhost:8080/furniture/mine'
const delete_url = 'http://localhost:8080/furniture/delete/'

@Injectable({
  providedIn: 'root'
})
export class FurnitureService {

  constructor(private http: HttpClient) { }


  createNewFurniture(data) : Observable<Furniture> {
    return this.http.post<Furniture>(create_url, data)
  }

  getAllFurniture(): Observable<Array<Furniture>> {
    return this.http.get<Array<Furniture>>(all_url);
  }

  getDetails(id : string) : Observable<Furniture> {
    return this.http.get<Furniture>(details_url + id);
  }

  myFurniture() : Observable<Array<Furniture>> {
    return this.http.get<Array<Furniture>>(my_furniture_url);
  }

  delete(id : string): Observable<any> {
    return this.http.delete<any>(delete_url + id);
  }
}



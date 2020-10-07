import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Category from '../model/category.model'

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private readonly all_categories_url = 'http://localhost:8080/categories/all'

  constructor(private http: HttpClient) { }

  all() {
    return this.http.get<Category[]>(this.all_categories_url);
  }

}

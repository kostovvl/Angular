import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private readonly create_category_url = 'http://localhost:8080/admin/category/create'

  constructor(private http: HttpClient) { }

  createCategory(form: Object) {
   return this.http.post(this.create_category_url, form);
  }

}

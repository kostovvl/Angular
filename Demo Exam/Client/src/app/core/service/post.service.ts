import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private readonly submit_post_url = 'http://localhost:8080/posts/create'

  constructor(private http: HttpClient) { }

  submit(form: Object) {
    return this.http.post(this.submit_post_url, form);
  }

}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private readonly create_comment_url = 'http://localhost:8080/comments/create'
  private readonly get_by_Id_url = 'http://localhost:8080/comments/getById/'

  constructor(private http: HttpClient) { }

  submit(form: Object) {
    return this.http.post(this.create_comment_url, form);
  }

  getById(id: number) {
    return this.http.get<Comment>(this.get_by_Id_url + id);
  }

}

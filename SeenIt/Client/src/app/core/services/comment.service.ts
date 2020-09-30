import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CommentService {
  
  constructor(
    private http: HttpClient
  ) { }

  getAllForPost(postId: string) {
    return this.http.get<Object[]>(``)
  }

  postComment(body: Object) {
    return this.http.post("shshs", body);
  }

  deleteComment(id: string) {
    return this.http.delete(`shshhs`);
  }
}
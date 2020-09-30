import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private readonly post_comment = 'http://localhost:8080/comments/create';
  private readonly all_for_post = 'http://localhost:8080/comments/post/'
  private readonly delete_comment = 'http://localhost:8080/comments/delete/';
  
  constructor(
    private http: HttpClient
  ) { }

  getAllForPost(postId: string) {
    return this.http.get<Object[]>(this.all_for_post + postId)
  }

  postComment(body: Object) {
    return this.http.post(this.post_comment, body);
  }

  deleteComment(id: string) {
    return this.http.delete(this.delete_comment + id);
  }
}
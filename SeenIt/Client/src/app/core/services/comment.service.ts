import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import Comment from 'src/app/components/common/models/comment.model';

 const POST_URL = 'http://localhost:8080/comments/create';
 const DELETE_URL = `http://localhost:8080/comments/delete/`;
 const ALL_FOR_POST = 'http://localhost:8080/comments/post/'

@Injectable({
  providedIn: 'root'
})
export class CommentService {
   

  constructor(
    private http: HttpClient
  ) { }

  getAllForPost(postId: string) {
    return this.http.get<Comment[]>(ALL_FOR_POST + postId)
  }

  postComment(body: Object) {
    return this.http.post(POST_URL, body);
  }

  deleteComment(id: string) {
    return this.http.delete(DELETE_URL + id);
  }
}
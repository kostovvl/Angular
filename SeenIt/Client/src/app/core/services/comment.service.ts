import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

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
    return this.http.get<Object[]>(ALL_FOR_POST + postId, {
      headers: new HttpHeaders({
        'Authorization': `Kinvey ${localStorage.getItem('token')}`
      })
    })
  }

  postComment(body: Object) {
    return this.http.post(POST_URL, body, {
      headers: new HttpHeaders({
        'Authorization': `Kinvey ${localStorage.getItem('token')}`
      })
    });
  }

  deleteComment(id: string) {
    return this.http.delete(DELETE_URL + id, {
      headers: new HttpHeaders({
        'Authorization': `Kinvey ${localStorage.getItem('token')}`
      })
    });
  }
}
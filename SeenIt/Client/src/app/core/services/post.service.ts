import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const ALL_URL = 'http://localhost:8080/posts/all'
const CREATE_URL = 'http://localhost:8080/posts/create'
const DETAILS_URL = 'http://localhost:8080/posts/details/';
const DELETE_URL = 'http://localhost:8080/posts/delete/';
const USER_POSTS_URL = 'http://localhost:8080/posts/user/'

@Injectable({
  providedIn: 'root'
})
export class PostService {
  
  constructor(
    private http: HttpClient
  ) { }

  getAll() {
    return this.http.get<Object[]>(ALL_URL);
  }

  createPost(body: Object) {
    return this.http.post(CREATE_URL, body);
  }

  getById(id: string) {
    return this.http.get<Object>(DETAILS_URL + id);
  }

  getDetails(id: string) {
    return this.http.get<Object>(DETAILS_URL + id);
  }

  // editPost(body: Object, id: string) {
  //   return this.http.put(this.CREATE_POST + `/${id}`, body, {
  //     headers: new HttpHeaders({
  //       'Authorization': `Kinvey ${localStorage.getItem('token')}`
  //     })
  //   });
  // }

  deletePost(id: string) {
    return this.http.delete(DELETE_URL + id);
  }

  getUserPosts() {
    const userId = localStorage.getItem('userId');
    return this.http
      .get<Object[]>(USER_POSTS_URL + userId);
  }
}
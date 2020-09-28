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
    return this.http.get<Object[]>(ALL_URL, {
      headers: new HttpHeaders({
        'Authorization': `Kinvey ${localStorage.getItem('token')}`
      })
    });
  }

  createPost(body: Object) {
    return this.http.post(CREATE_URL, body, {
      headers: new HttpHeaders({
        'Authorization': `Kinvey ${localStorage.getItem('token')}`
      })
    });
  }

  getById(id: string) {
    return this.http.get<Object>(DETAILS_URL);
  }

  getDetails(id: string) {
    return this.http.get<Object>(DETAILS_URL);
  }

  // editPost(body: Object, id: string) {
  //   return this.http.put(this.CREATE_POST + `/${id}`, body, {
  //     headers: new HttpHeaders({
  //       'Authorization': `Kinvey ${localStorage.getItem('token')}`
  //     })
  //   });
  // }

  deletePost(id: string) {
    return this.http.delete(DELETE_URL);
  }

  getUserPosts() {
    const username = localStorage.getItem('username');
    return this.http
      .get<Object[]>(USER_POSTS_URL + username);
  }
}
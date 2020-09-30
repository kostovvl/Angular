import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class PostService {
  private readonly BASE_URL = `https://baas.kinvey.com/appdata/`;
  private readonly ALL_POSTS = `hui`;
  private readonly CREATE_POST = `${this.BASE_URL}/posts`;

  constructor(
    private http: HttpClient
  ) { }

  getAll() {
    return this.http.get<Object[]>(this.ALL_POSTS);
  }

  createPost(body: Object) {
    return this.http.post(this.CREATE_POST, body);
  }

  getById(id: string) {
    return this.http.get<Object>(this.CREATE_POST + `/${id}`);
  }

  getDetails(id: string) {
    return this.http.get<Object>(this.CREATE_POST + `/${id}`);
  }

  editPost(body: Object, id: string) {
    return this.http.put(this.CREATE_POST + `/${id}`, body);
  }

  deletePost(id: string) {
    return this.http.delete(this.CREATE_POST + `/${id}`);
  }

  getUserPosts() {
    return this.http
      .get<Object[]>(`hui`);
  }
}
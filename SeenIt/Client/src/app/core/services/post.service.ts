import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import Post from 'src/app/posts/models/post.model';


@Injectable({
  providedIn: 'root'
})
export class PostService {
  private readonly create_post = 'http://localhost:8080/posts/create'
  private readonly all_posts = 'http://localhost:8080/posts/all'
  private readonly user_posts = 'http://localhost:8080/posts/user/'
  private readonly delete_post = 'http://localhost:8080/posts/delete/'
  private readonly details_post = 'http://localhost:8080/posts/details/'
  private readonly edit_post = 'http://localhost:8080/posts/edit/'


  constructor(
    private http: HttpClient
  ) { }

  getAll() {
    return this.http.get<Post[]>(this.all_posts);
  }

  createPost(body: Object) {
    return this.http.post<Post>(this.create_post, body);
  }

  getById(id: string) {
    return this.http.get<Comment>(this.details_post + id);
  }

  getDetails(id: string) {
    return this.http.get<Post>(this.details_post + id);
  }

  editPost(body: Object, id: string) {
    return this.http.put(this.edit_post + id, body);
  }

  deletePost(id: string) {
    return this.http.delete(this.delete_post + id);
  }

  getUserPosts() {
    const userId = localStorage.getItem('userId')
    return this.http.get<Post[]>(this.user_posts + userId);
  }
}
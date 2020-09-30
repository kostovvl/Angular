import { Component, Input, 
  OnInit, Output, EventEmitter } from '@angular/core';
import Post from '../models/post.model';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  @Input('post') post: Post;
  @Output() deletePostEvent: EventEmitter<number> = new EventEmitter;

  constructor() { }

  ngOnInit() {
  }

  deletePost(id: number) {
    this.deletePostEvent.emit(id);
  }

  isAuthor(post) {
  return post['creatorId'] == localStorage.getItem('userId');
  }

}

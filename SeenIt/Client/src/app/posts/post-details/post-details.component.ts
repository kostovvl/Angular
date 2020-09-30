import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { CommentService } from 'src/app/core/services/comment.service';
import { PostService } from 'src/app/core/services/post.service';
import Post from '../models/post.model';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent implements OnInit {
  @ViewChild('f') createCommentForm: NgForm;
  post: Post;
  comments: Object[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private postService: PostService,
    private commentService: CommentService
  ) { }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    this.postService.getDetails(id)
      .subscribe((data) => {
        this.post = data;
        this.commentService.getAllForPost(this.post['id'])
          .subscribe((data) => {
            this.comments = data;
          });
      });
  }

  loadComments() {
    this.commentService.getAllForPost(this.post['_id'])
      .subscribe((data) => {
        this.comments = data;
      });
  }

  deleteComment(id: string) {
    this.commentService.deleteComment(id)
      .subscribe(() => {
        this.loadComments();
      })
  }

  postComment() {
    const body = this.createCommentForm.value;
    body['postId'] = this.post['id'];
    body['author'] = localStorage.getItem('username');
    body['creatorId'] = localStorage.getItem('userId');

    this.commentService
      .postComment(this.createCommentForm.value)
      .subscribe(() => {
        this.createCommentForm.reset();
        this.loadComments();
      })
  }

  isAuthor() {
    return this.post['creatorId'] === localStorage.getItem('userId');
  }

  deletePost(id: string) {
    this.postService.deletePost(id)
      .subscribe(() => {
        this.router.navigate(['/posts']);
      })
  }
}

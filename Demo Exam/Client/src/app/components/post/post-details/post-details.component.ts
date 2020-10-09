import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import Post from 'src/app/core/model/post.model';
import Comment from 'src/app/core/model/comment.model'
import { AuthService } from 'src/app/core/service/auth.service';
import { PostService } from 'src/app/core/service/post.service';
import { CommentService } from 'src/app/core/service/comment.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.css']
})
export class PostDetailsComponent implements OnInit {

  post: Post;
  comments$ : Observable<Comment[]>;
  form;

  constructor(
    private postService: PostService,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private authService: AuthService,
    private commentService: CommentService
    ) { }

  ngOnInit(): void {
    let postId = this.route.snapshot.params['id'];
    this.postService.postDetails(postId)
    .subscribe(data => {
      this.post = data
      this.form = this.fb.group({
        content: ['', Validators.required],
        creatorName: [this.authService.getUsername()],
        creatorId: [this.authService.getUserId()],
        postId: [this.post.id]
      })
      this.comments$ = this.commentService.getForPost(this.post.id);
    })  
  }

  get f() {
    return this.form.controls;
  }

  submit() {
    this.commentService.submit(this.form.value)
    .subscribe(data => {
      this.ngOnInit();
    })

  }

}

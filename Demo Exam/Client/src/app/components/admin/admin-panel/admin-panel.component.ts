import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import Post from 'src/app/core/model/post.model';
import { AdminService } from 'src/app/core/service/admin.service'
import { CommentService } from 'src/app/core/service/comment.service';
import { PostService } from 'src/app/core/service/post.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  form;
  PostsforApproval$: Observable<Object[]>
  CommentsForApproval$: Observable<Object[]>
  post: Post
  comment: Comment

  constructor(
    private fb: FormBuilder,
    private adminService: AdminService,
    private postService: PostService,
    private commentService: CommentService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      name: ['', Validators.required]
    })
    this.PostsforApproval$ = this.adminService.getAllPostsForApproval();
    this.CommentsForApproval$ = this.adminService.getAllCommentsForApproval();
  }

  get f() {
    return this.form.controls;
  }

  set p(Object) {
    this.post = null;
  }

  submit() {
    this.adminService.createCategory(this.form.value)
    .subscribe(data => {
      this.router.navigate([ '/home' ])
    })
  }

  postDetails(id: number) {
    this.postService.postDetails(id).subscribe(data => {
      this.post = data;
    })
  }

  clearPost() {
    this.ngOnInit();
  }

  commentDetails(id : number) {
    this.commentService.getById(id).subscribe(data => {
      this.comment = data;
    })
  }

}

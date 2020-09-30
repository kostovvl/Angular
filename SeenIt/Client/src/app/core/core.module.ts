import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from './services/auth.service';
import { CommentService } from './services/comment.service';
import { PostService } from './services/post.service';

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ], 
  providers: [
    AuthService, 
    CommentService,
    PostService
  ]
})
export class CoreModule { }

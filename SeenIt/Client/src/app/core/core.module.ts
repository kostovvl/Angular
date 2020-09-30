import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from './services/auth.service';
import { CommentService } from './services/comment.service';
import { PostService } from './services/post.service';
import { JwtInterceptorService } from './interceptors/jwt-interceptor.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ], 
  providers: [
    AuthService, 
    CommentService,
    PostService,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptorService, multi: true}
  ]
})
export class CoreModule { }

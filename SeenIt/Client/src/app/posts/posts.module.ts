import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostComponent } from './post/post.component';
import { PostCreateComponent } from './post-create/post-create.component';
import { PostDetailsComponent } from './post-details/post-details.component';
import { PostEditComponent } from './post-edit/post-edit.component';
import { PostListComponent } from './post-list/post-list.component';
import { CommentsModule } from '../comments/comments.module';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    PostCreateComponent, 
    PostDetailsComponent, 
    PostEditComponent,
    PostListComponent,
    PostComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    CommentsModule
  ], 
  exports: [
    PostCreateComponent, 
    PostDetailsComponent, 
    PostEditComponent,
    PostListComponent,
    PostComponent, 
  ]
})
export class PostsModule { }

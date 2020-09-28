import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostCreateComponent } from '../post-create/post-create.component';
import { PostDetailsComponent } from '../post-details/post-details.component';
import { PostEditComponent } from '../post-edit/post-edit.component';
import { PostListComponent } from '../post-list/post-list.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CommentComponent } from '../../comments/comment/comment.component';

@NgModule({
  declarations: [
    PostListComponent,
    PostCreateComponent,
    PostEditComponent,
    PostDetailsComponent,
    CommentComponent
  ],
  imports: [
    CommonModule,
    FormsModule, 
    RouterModule,
  ]
})
export class PostsModule { }

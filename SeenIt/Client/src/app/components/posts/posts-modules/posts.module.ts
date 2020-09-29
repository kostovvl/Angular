import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostCreateComponent } from '../post-create/post-create.component';
import { PostDetailsComponent } from '../post-details/post-details.component';
import { PostEditComponent } from '../post-edit/post-edit.component';
import { PostListComponent } from '../post-list/post-list.component';
import { FormsModule } from '@angular/forms';
import { CommentsModule } from '../../comments/comments.module';
import { PostRoutnigModule } from './posts-routing.module';


@NgModule({
  declarations: [
    PostListComponent,
    PostCreateComponent,
    PostEditComponent,
    PostDetailsComponent,
  ],
  imports: [
    CommonModule,
    FormsModule, 
    PostRoutnigModule,
    CommentsModule
  ]
})
export class PostsModule { }

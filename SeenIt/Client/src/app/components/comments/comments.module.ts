import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CommentComponent } from './comment/comment.component';


@NgModule({
  declarations: [
  CommentComponent
  ],
  imports: [
    CommonModule,
    FormsModule, 
    RouterModule,
  ], 
  exports: [
      CommentComponent
  ]
})
export class CommentsModule { }

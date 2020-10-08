import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostCreateComponent } from './post-create/post-create.component';
import { PostAllComponent } from './post-all/post-all.component';
import { PostDetailsComponent } from './post-details/post-details.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [PostCreateComponent, PostAllComponent, PostDetailsComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  exports: [
    PostCreateComponent, PostAllComponent, PostDetailsComponent
  ]
})
export class PostModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { ReactiveFormsModule } from '@angular/forms';
import { PostModule } from '../post/post.module';



@NgModule({
  declarations: [AdminPanelComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    PostModule
  ],
  exports: [
    AdminPanelComponent
  ]
})
export class AdminModule { }

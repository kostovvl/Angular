import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [AdminPanelComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  exports: [
    AdminPanelComponent
  ]
})
export class AdminModule { }

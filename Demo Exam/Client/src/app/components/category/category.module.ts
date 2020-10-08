import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AllCategoriesComponent } from './all-categories/all-categories.component';




@NgModule({
  declarations: [AllCategoriesComponent],
  imports: [
    CommonModule,
  ],
  exports: [
    AllCategoriesComponent
  ]
})
export class CategoryModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AllCategoriesComponent } from './all-categories/all-categories.component';
import { CategoryDetailsComponent } from './category-details/category-details.component';



@NgModule({
  declarations: [AllCategoriesComponent, CategoryDetailsComponent],
  imports: [
    CommonModule
  ],
  exports: [
    AllCategoriesComponent, CategoryDetailsComponent
  ]
})
export class CategoryModule { }

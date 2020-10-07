import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoryService } from 'src/app/core/service/category.service';
import Category from 'src/app/core/model/category.model';

@Component({
  selector: 'app-all-categories',
  templateUrl: './all-categories.component.html',
  styleUrls: ['./all-categories.component.css']
})
export class AllCategoriesComponent implements OnInit {

  allCategories$ : Observable<Category[]>

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {

    this.allCategories$ = this.categoryService.all();

  }

}

import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoryService } from 'src/app/core/service/category.service';
import Category from 'src/app/core/model/category.model';
import { AuthService } from 'src/app/core/service/auth.service';

@Component({
  selector: 'app-all-categories',
  templateUrl: './all-categories.component.html',
  styleUrls: ['./all-categories.component.css']
})
export class AllCategoriesComponent implements OnInit {

  allCategories$ : Observable<Category[]>

  constructor(
    private categoryService: CategoryService,
    private authService: AuthService
    ) { }

  ngOnInit(): void {

    this.allCategories$ = this.categoryService.all();

  }

  canDelete() {
    if (this.authService.isAuthenticated()) {
      if (this.authService.isAdmin()) {
        return true;
      }
      return false;
    } 
    return false;
  }



  delete(id: number) {
    this.categoryService.delete(id)
    .subscribe(data => {
      this.ngOnInit();
    })
    
  }

}

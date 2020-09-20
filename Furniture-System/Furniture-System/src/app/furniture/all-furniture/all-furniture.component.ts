import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/authentication/auth.service';
import Furniture from '../furniture.model';
import { FurnitureService } from '../furniture.service';

@Component({
  selector: 'app-all-furniture',
  templateUrl: './all-furniture.component.html',
  styleUrls: ['./all-furniture.component.css']
})
export class AllFurnitureComponent implements OnInit {

  result$: Observable<Furniture[]>;

  constructor(private furnitureService: FurnitureService,
    private authService: AuthService,) { }

  ngOnInit() {
    this.result$ = this.furnitureService.getAllFurniture();
  }

  deleteAdmin(id : string) {
    this.furnitureService.deleteAdmin(id).subscribe(
      data => {
        this.result$ = this.furnitureService.getAllFurniture();
      }
    );
  }

}

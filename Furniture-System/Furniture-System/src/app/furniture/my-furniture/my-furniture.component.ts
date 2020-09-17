import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import Furniture from '../furniture.model';
import { FurnitureService } from '../furniture.service';

@Component({
  selector: 'app-my-furniture',
  templateUrl: './my-furniture.component.html',
  styleUrls: ['./my-furniture.component.css']
})
export class MyFurnitureComponent implements OnInit {

  result$: Observable<Furniture[]>;

  constructor(private furnitureService : FurnitureService,
    private router: Router) { }

  ngOnInit() {
     this.result$ = this.furnitureService.myFurniture();
  }

  delete(id : string) {
    this.furnitureService.delete(id).subscribe( data => {
      this.result$ = this.furnitureService.myFurniture();
    });
   
  }

}

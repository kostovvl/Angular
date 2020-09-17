import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import Furniture from '../furniture.model';
import { FurnitureService } from '../furniture.service';

@Component({
  selector: 'app-details-furniture',
  templateUrl: './details-furniture.component.html',
  styleUrls: ['./details-furniture.component.css']
})
export class DetailsFurnitureComponent implements OnInit {

  result : Furniture;

  constructor(private furnitureService: FurnitureService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];
    this.furnitureService.getDetails(id)
    .subscribe(data => {
      this.result = data;
    })
  }

}

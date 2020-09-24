import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FurnitureService } from '../furniture.service';
import Furniture from '../model.furniture';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  furniture: Furniture;
  

  constructor(private service: FurnitureService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.service.details(this.route.snapshot.params['id'])
    .subscribe((data) => {
      console.log(data)
      this.furniture = data;
    })
  }

}

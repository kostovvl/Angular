import { Component, OnInit } from '@angular/core';
import { FurnitureService } from '../furniture.service';

@Component({
  selector: 'app-my',
  templateUrl: './my.component.html',
  styleUrls: ['./my.component.css']
})
export class MyComponent implements OnInit {

 
  furniture$;

  constructor(private service: FurnitureService) { }

  ngOnInit() {
    this.furniture$ = this.service.mine();
  }

  delete(id : number) {
    this.service.delete(id, localStorage.getItem('user'))
    .subscribe(data => {
      console.log(data)
      this.furniture$ = this.service.mine();
    });
  }

}

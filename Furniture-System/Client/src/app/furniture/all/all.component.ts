import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/authentication/auth.service';
import { FurnitureService } from '../furniture.service';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {

  furniture$;

  constructor(private service: FurnitureService, 
    private auth: AuthService) { }

  ngOnInit() {
    this.furniture$ = this.service.all();
  }

  deleteAdmin(id: number) {
    this.service.deleteAdmin(id)
    .subscribe((data) => {
      this.furniture$ = this.service.all();
    })
  }

}

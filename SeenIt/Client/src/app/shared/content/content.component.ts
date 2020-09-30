import { Component, DoCheck, OnInit } from '@angular/core';
import { AuthService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements DoCheck {

  date: Date = new Date();
  username: string = '';
  isLoggedIn: boolean;

  constructor(private authService: AuthService) { }

  

  ngDoCheck() {
    this.username = localStorage.getItem('username');
    this.isLoggedIn = this.authService.isAuthenticated();
  }

}

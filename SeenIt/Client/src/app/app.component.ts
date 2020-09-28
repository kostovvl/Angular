import { Component, DoCheck } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './core/services/auth.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements DoCheck {
  date: Date = new Date();
  username: string = '';
  isLoggedIn: boolean;

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngDoCheck() {
    this.username = localStorage.getItem('username');
    this.isLoggedIn = this.authService.isAuthenticated();
  }

  logout() {
    this.authService.logout()
    this.router.navigate([ '/login' ])
  }
}

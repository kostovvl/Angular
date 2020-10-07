import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/core/service/user.service';
import { AuthService } from 'src/app/core/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form;

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private authService: AuthService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  get f() {
    return this.form.controls;
  }

  login() {
   this.userService.login(this.form.value)
   .subscribe( data => {
     console.log(data)
     this.authService.setLoggedUserInfo(data);
     console.log(this.authService.getUsername());
     console.log(this.authService.getUserId());
     console.log(this.authService.getRoles());
     console.log(this.authService.getToken());
     this.router.navigate(['/home'])
   } )
  }


}

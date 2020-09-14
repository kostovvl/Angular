import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UsersService } from '../service/users.service';
import { ConfirmedValidator } from './password-matcher';
import {Router} from "@angular/router"

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  form;
  numberPrefixes: string[];
  positions: string[];

  constructor(private fb: FormBuilder,
    private userService: UsersService, 
    private router: Router) { 
    this.numberPrefixes = ['+359', '+340', '+254'];
    this.positions = ['Developer', 'Manager', 'QA']
  }

  ngOnInit(): void {
    this.form = this.fb.group(
      {fullName: ['', [Validators.required]],
      email: ['', [Validators.required]],
      phonePrefix: [''],
      phoneNumber: ['', [Validators.required]],
      position: ['', [Validators.required]],
      password: ['', [Validators.required]],
      passwordConfirm: ['']
    }, {
      validator: ConfirmedValidator('password', 'passwordConfirm')
    }
    );
  }

  get f() {
    return this.form.controls;
  }

  submit() {
   if (this.form.valid) {
    let result$ = this.userService.register(this.form).subscribe(
      data => {
        console.log(data)
      }
    );
      this.form.reset();
      this.router.navigate(['login'])
   }
  }

}

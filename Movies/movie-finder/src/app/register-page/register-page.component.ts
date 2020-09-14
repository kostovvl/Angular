import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UsersService } from '../service/users.service';
import { ConfirmedValidator } from './password-matcher';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  form;
  numberPrefixes: string[];
  possitions: string[];

  constructor(private fb: FormBuilder,
    private userService: UsersService) { 
    this.numberPrefixes = ['+359', '+340', '+254'];
    this.possitions = ['Developer', 'Manager', 'QA']
  }

  ngOnInit(): void {
    this.form = this.fb.group(
      {fullName: ['', [Validators.required]],
      email: ['', [Validators.required]],
      phonePrefix: [''],
      phoneNumber: ['', [Validators.required]],
      possition: ['', [Validators.required]],
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
    let result$ = this.userService.register(this.form);
     this.form.reset();
   }
  }

}

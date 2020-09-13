import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

import { ConfirmedValidator } from './confirm-password';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  phonePrefixes: string[];
  possitions: string[];
  form;

  constructor(private fb: FormBuilder) {
    this.phonePrefixes = ['+359', '+324', '+213'];
    this.possitions = ['Developer', 'Designer', 'Manager']
   }

  ngOnInit(): void {
    this.form = this.fb.group({
      fullName: ['', [Validators.required, Validators.pattern('([A-Z][a-z]+)\\s([A-Z][a-z]+)')]],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', [Validators.required, Validators.pattern('^[\\d]{9}$')]],
      possition: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['']
    }, {
  
      validator: ConfirmedValidator('password', 'confirmPassword')
    });
  }

 get f() {
   return this.form.controls;
  }

  register() {
    if (this.form.valid) {
      debugger
      this.form.reset();
    }
    console.log(this.form);
  }

}

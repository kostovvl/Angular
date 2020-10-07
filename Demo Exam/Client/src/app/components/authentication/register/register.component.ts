import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/core/service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form;

  constructor(private fb: FormBuilder, 
    private userService: UserService) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  get f() {
    return this.form.controls;
  }

  register() {
      this.userService.register(this.form.value)
      .subscribe( data => {
        this.form.reset
      })
  }

}

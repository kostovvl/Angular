import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    RegisterComponent,
    LoginComponent],
  imports: [
    FormsModule,
    RouterModule,
    CommonModule
  ], 
  exports: [
    RegisterComponent, 
    LoginComponent
  ]
})
export class AuthenticationModule { }

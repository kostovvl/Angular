import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { SigninComponent } from './authentication/signin/signin.component';
import { SignupComponent } from './authentication/signup/signup.component';
import { HomeComponent } from './home/home.component';
import { DropdownDirective } from './navigation/dropdown.directive';
import { CollapseDirective } from './navigation/collapse.directive';

import { AppRoutingModule } from './app-routing.module';
import { AuthService } from './authentication/auth.service';
import { JwtInterceptorService } from './authentication/interceptors/jwt-interceptor.service';
import { ToastrModule } from 'ngx-toastr';
import { ToastrInterceptorService } from './authentication/interceptors/toastr-interceptor.service';
import { CreateComponent } from './furniture/create/create.component';
import { AllComponent } from './furniture/all/all.component';
import { DetailsComponent } from './furniture/details/details.component';
import { FurnitureService } from './furniture/furniture.service';
import { MyComponent } from './furniture/my/my.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    SigninComponent,
    SignupComponent,
    HomeComponent,
    DropdownDirective,
    CollapseDirective,
    CreateComponent,
    AllComponent,
    DetailsComponent,
    MyComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    ToastrModule.forRoot(),
  ],
  providers: [ 
    AuthService,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptorService, multi: true},
    { provide: HTTP_INTERCEPTORS, useClass: ToastrInterceptorService, multi: true},
    FurnitureService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

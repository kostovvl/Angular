import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { RegisterPageComponent } from './register-page/register-page.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'movies'},
  {path: 'movies', component: LandingPageComponent},
  {path: 'movies/:id', component: MovieDetailsComponent},
   {path: 'register', component: RegisterPageComponent},
   {path: 'login', component: LoginPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

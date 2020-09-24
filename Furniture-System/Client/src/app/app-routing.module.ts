import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Components
import { HomeComponent } from './home/home.component';
import { SigninComponent } from './authentication/signin/signin.component';
import { SignupComponent } from './authentication/signup/signup.component';
import { CreateComponent } from './furniture/create/create.component';
import { AuthGuard } from './authentication/guards/auth.guard';
import { AllComponent } from './furniture/all/all.component';
import { DetailsComponent } from './furniture/details/details.component';
import { MyComponent } from './furniture/my/my.component';
import { AuthService } from './authentication/auth.service';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: HomeComponent },
  { path: 'signin', component: SigninComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'furniture/create', component: CreateComponent, canActivate: [AuthGuard]},
  { path: 'furniture/all', component: AllComponent }, 
  { path: 'furniture/details/:id', component: DetailsComponent},
  { path: 'furniture/user', component: MyComponent, canActivate: [AuthGuard] }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
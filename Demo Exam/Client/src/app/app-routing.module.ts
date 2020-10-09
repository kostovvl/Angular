import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/authentication/login/login.component';
import { RegisterComponent } from './components/authentication/register/register.component';
import { LandingPageComponent } from './components/shared/landing-page/landing-page.component';
import { AdminPanelComponent } from './components/admin/admin-panel/admin-panel.component';
import { PostCreateComponent } from './components/post/post-create/post-create.component';
import { PostAllComponent } from './components/post/post-all/post-all.component';
import { PostDetailsComponent } from './components/post/post-details/post-details.component';
import { UnAuthGuard } from 'src/app/core/guard/unAuth.guard';
import { AdminGuard } from 'src/app/core/guard/admin.guard';
import { AuthGuard } from 'src/app/core/guard/auth.guard';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'home', component: LandingPageComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent, canActivate: [UnAuthGuard]},
  {path: 'admin', component: AdminPanelComponent, canActivate: [AuthGuard, AdminGuard]},
  {path: 'posts/create', component: PostCreateComponent, canActivate: [AuthGuard] },
  {path: 'posts/all/:id', component: PostAllComponent}, 
  {path: 'post/details/:id', component: PostDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

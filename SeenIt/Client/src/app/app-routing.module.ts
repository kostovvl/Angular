import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/authentication/login/login.component';
import { RegisterComponent } from './components/authentication/register/register.component';
import { AuthGuard } from './core/guards/auth-guard';


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/login' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
   { path: 'posts', loadChildren: 'src/app/components/posts/posts-modules/posts.module#PostsModule', 
  canLoad: [AuthGuard] },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

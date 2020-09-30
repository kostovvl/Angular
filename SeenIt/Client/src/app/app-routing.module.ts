import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './authentication/login/login.component';
import { RegisterComponent } from './authentication/register/register.component';
import { PostCreateComponent } from './posts/post-create/post-create.component';
import { PostDetailsComponent } from './posts/post-details/post-details.component';
import { PostEditComponent } from './posts/post-edit/post-edit.component';
import { PostListComponent } from './posts/post-list/post-list.component';


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/login' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'posts', component: PostListComponent },
  { path: 'posts/user', component: PostListComponent },
  { path: 'posts/create', component: PostCreateComponent },
  { path: 'posts/edit/:id', component: PostEditComponent },
  { path: 'posts/details/:id', component: PostDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

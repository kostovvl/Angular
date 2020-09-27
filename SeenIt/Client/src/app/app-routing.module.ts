import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/authentication/login/login.component';
import { RegisterComponent } from './components/authentication/register/register.component';
import { PostCreateComponent } from './components/posts/post-create/post-create.component';
import { PostDetailsComponent } from './components/posts/post-details/post-details.component';
import { PostEditComponent } from './components/posts/post-edit/post-edit.component';
import { PostListComponent } from './components/posts/post-list/post-list.component';

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

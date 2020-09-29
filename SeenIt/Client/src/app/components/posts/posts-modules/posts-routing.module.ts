import { NgModule } from '@angular/core';
import { from } from 'rxjs';
import { Router, Route, RouterModule} from '@angular/router'
import { PostCreateComponent } from '../post-create/post-create.component';
import { PostDetailsComponent } from '../post-details/post-details.component';
import { PostEditComponent } from '../post-edit/post-edit.component';
import { PostListComponent } from '../post-list/post-list.component';


const postRoutes: Route[] = [
  {path: '', pathMatch: 'full', component: PostListComponent},
  { path: 'user', component: PostListComponent },
  { path: 'create', component: PostCreateComponent },
  { path: 'edit/:id', component: PostEditComponent },
  { path: 'details/:id', component: PostDetailsComponent }
]

@NgModule({
    imports: [
        RouterModule.forChild(postRoutes)
    ], 
    exports: [
        RouterModule
    ]
    
  })


  export class PostRoutnigModule{

  }
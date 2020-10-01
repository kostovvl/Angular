import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContentComponent } from './content/content.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { AuthenticationModule } from '../authentication/authentication.module';
import { RouterModule } from '@angular/router';
import { PostsModule } from '../posts/posts.module';


@NgModule({
  declarations: [
    HeaderComponent,
     ContentComponent, 
     FooterComponent],
  imports: [
    CommonModule, 
    RouterModule,
    AuthenticationModule,
  ], 
  exports: [
    HeaderComponent,
    ContentComponent, 
    FooterComponent,
  ]
})
export class SharedModule { }

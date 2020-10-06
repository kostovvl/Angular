import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationComponent } from './navigation/navigation.component';
import { FooterComponent } from './footer/footer.component';
import { ContentComponent } from './content/content.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [NavigationComponent, FooterComponent, ContentComponent],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    NavigationComponent, FooterComponent, ContentComponent
  ]
})
export class SharedModule { }

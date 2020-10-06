import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationComponent } from './navigation/navigation.component';
import { FooterComponent } from './footer/footer.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [NavigationComponent, FooterComponent, LandingPageComponent],
  imports: [
    CommonModule,
    RouterModule
  ], 
  exports: [
    NavigationComponent, FooterComponent, LandingPageComponent
  ]
})
export class SharedModule { }

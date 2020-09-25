import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateComponent } from './create/create.component';
import { AllComponent } from './all/all.component';
import { DetailsComponent } from './details/details.component';
import { MyComponent } from './my/my.component';
import { FurnitureService } from './furniture.service';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule.forChild([
    {path: '', pathMatch: 'full', redirectTo: 'home'},
    { path: 'create', component: CreateComponent, },
    { path: 'all', component: AllComponent }, 
    { path: 'details/:id', component: DetailsComponent},
    { path: 'user', component: MyComponent }])
  ],
  declarations: [ 
    CreateComponent,
    AllComponent,
    DetailsComponent,
    MyComponent], 
  providers: [
    FurnitureService
  ]
})
export class FurnitureModule { }

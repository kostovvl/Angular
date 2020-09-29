import { NgModule } from '@angular/core';
import { HeaderComponent } from './header/header.component';
import { ContentComponent } from './content/content.component';
import { FooterComponent } from './footer/footer.component';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@NgModule({
    declarations: [
        HeaderComponent, 
        ContentComponent, 
        FooterComponent
    ],
    imports: [
      CommonModule,
      RouterModule
    ],
    exports: [
        HeaderComponent, 
        ContentComponent, 
        FooterComponent
    ]
  })

export class SharedModule {}
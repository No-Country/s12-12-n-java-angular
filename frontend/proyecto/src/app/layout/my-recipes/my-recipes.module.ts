import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MyRecipesRoutingModule } from './my-recipes-routing.module';
import { MyRecipesComponent } from './my-recipes.component';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    MyRecipesComponent
  ],
  imports: [
    CommonModule,
    MyRecipesRoutingModule,
    SharedModule
  ]
})
export class MyRecipesModule { }

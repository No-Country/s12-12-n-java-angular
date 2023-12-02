import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CreateRecipeRoutingModule } from './create-recipe-routing.module';
import { CreateRecipeComponent } from './create-recipe.component';


@NgModule({
  declarations: [
    CreateRecipeComponent
  ],
  imports: [
    CommonModule,
    CreateRecipeRoutingModule
  ]
})
export class CreateRecipeModule { }

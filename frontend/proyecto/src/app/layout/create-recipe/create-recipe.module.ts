import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { CreateRecipeRoutingModule } from './create-recipe-routing.module';
import { CreateRecipeComponent } from './create-recipe.component';


@NgModule({
  declarations: [
    CreateRecipeComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    CreateRecipeRoutingModule
  ]
})
export class CreateRecipeModule { }

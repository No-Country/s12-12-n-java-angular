import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EditRecipeRoutingModule } from './edit-recipe-routing.module';
import { EditRecipeComponent } from './edit-recipe.component';


@NgModule({
  declarations: [
    EditRecipeComponent
  ],
  imports: [
    CommonModule,
    EditRecipeRoutingModule
  ]
})
export class EditRecipeModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { EditRecipeRoutingModule } from './edit-recipe-routing.module';
import { EditRecipeComponent } from './edit-recipe.component';


@NgModule({
  declarations: [
    EditRecipeComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    EditRecipeRoutingModule
  ]
})
export class EditRecipeModule { }

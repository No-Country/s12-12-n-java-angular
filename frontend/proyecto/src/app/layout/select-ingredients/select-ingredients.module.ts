import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SelectIngredientsRoutingModule } from './select-ingredients-routing.module';
import { SelectIngredientsComponent } from './select-ingredients.component';


@NgModule({
  declarations: [
    SelectIngredientsComponent
  ],
  imports: [
    CommonModule,
    SelectIngredientsRoutingModule
  ]
})
export class SelectIngredientsModule { }

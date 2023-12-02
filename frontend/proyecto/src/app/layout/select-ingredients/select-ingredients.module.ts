import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SelectIngredientsRoutingModule } from './select-ingredients-routing.module';
import { SelectIngredientsComponent } from './select-ingredients.component';
import { ItemListComponent } from './comps/item-list/item-list.component';


@NgModule({
  declarations: [
    SelectIngredientsComponent,
    ItemListComponent
  ],
  imports: [
    CommonModule,
    SelectIngredientsRoutingModule
  ]
})
export class SelectIngredientsModule { }

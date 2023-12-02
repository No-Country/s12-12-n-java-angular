import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RecipesRoutingModule } from './recipes-routing.module';
import { RecipesComponent } from './recipes.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { RecipeMiniCardComponent } from './comps/recipe-mini-card/recipe-mini-card.component';


@NgModule({
  declarations: [
    RecipesComponent,
    RecipeMiniCardComponent
  ],
  imports: [
    CommonModule,
    RecipesRoutingModule,
    SharedModule
  ]
})
export class RecipesModule { }

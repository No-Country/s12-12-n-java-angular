import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RecipesRoutingModule } from './recipes-routing.module';
import { RecipesComponent } from './recipes.component';
import { RecipeMiniCardComponent } from './comps/recipe-mini-card/recipe-mini-card.component';
import { RecipeCardComponent } from './comps/recipe-card/recipe-card.component';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    RecipesComponent,
    RecipeMiniCardComponent,
    RecipeCardComponent
  ],
  imports: [
    CommonModule,
    RecipesRoutingModule,
    SharedModule
  ]
})
export class RecipesModule { }

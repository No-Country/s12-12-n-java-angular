import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { CategoriesComponent } from './components/categories/categories.component';
import { BestRecipesComponent } from './components/bestRecipes/best-recipes.component';
import { AboutComponent } from './components/about/about.component';





@NgModule({
  declarations: [
    HomeComponent,
    CategoriesComponent,
    BestRecipesComponent,
    AboutComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule
  ]
})
export class HomeModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RecipeDetailsComponent } from './recipe-details.component';
import { RecipeDetailsRoutingModule } from './recipe-details-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';



@NgModule({
  declarations: [
    RecipeDetailsComponent
  ],
  imports: [
    CommonModule,
    RecipeDetailsRoutingModule,
    SharedModule
  ]
})
export class RecipeDetailsModule { }

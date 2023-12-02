import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchBoxComponent } from './search-box/search-box.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { RecipeCardComponent } from './recipe-card/recipe-card.component';



@NgModule({
  declarations: [
    SearchBoxComponent,
    RecipeCardComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  exports:[
    SearchBoxComponent,
    RecipeCardComponent
  ]
})
export class SharedModule { }

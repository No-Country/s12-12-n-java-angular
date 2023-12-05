import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateRecipeComponent } from './create-recipe.component';

const routes: Routes = [
  { path:"", component:CreateRecipeComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CreateRecipeRoutingModule { }

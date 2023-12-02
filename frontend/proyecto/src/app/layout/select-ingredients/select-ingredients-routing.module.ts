import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SelectIngredientsComponent } from './select-ingredients.component';

const routes: Routes = [
  { path:"", component:SelectIngredientsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SelectIngredientsRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateListComponent } from './create-list.component';

const routes: Routes = [
  { path:"", component:CreateListComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CreateListRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CreateListRoutingModule } from './create-list-routing.module';
import { CreateListComponent } from './create-list.component';
import { ListEditComponent } from './comps/list-edit/list-edit.component';


@NgModule({
  declarations: [
    CreateListComponent,
    ListEditComponent
  ],
  imports: [
    CommonModule,
    CreateListRoutingModule
  ]
})
export class CreateListModule { }

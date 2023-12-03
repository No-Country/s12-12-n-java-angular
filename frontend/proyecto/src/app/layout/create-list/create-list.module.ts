import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CreateListRoutingModule } from './create-list-routing.module';
import { CreateListComponent } from './create-list.component';


@NgModule({
  declarations: [
    CreateListComponent
  ],
  imports: [
    CommonModule,
    CreateListRoutingModule
  ]
})
export class CreateListModule { }

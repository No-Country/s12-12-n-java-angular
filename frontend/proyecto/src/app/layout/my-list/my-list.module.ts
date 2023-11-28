import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MyListRoutingModule } from './my-list-routing.module';
import { MyListComponent } from './my-list.component';


@NgModule({
  declarations: [
    MyListComponent
  ],
  imports: [
    CommonModule,
    MyListRoutingModule
  ]
})
export class MyListModule { }

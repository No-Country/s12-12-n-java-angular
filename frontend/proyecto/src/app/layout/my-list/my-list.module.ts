import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MyListRoutingModule } from './my-list-routing.module';
import { MyListComponent } from './my-list.component';
import { ListItemComponent } from './comps/list-item/list-item.component';
import { ListCardComponent } from './comps/list-card/list-card.component';


@NgModule({
  declarations: [
    MyListComponent,
    ListItemComponent,
    ListCardComponent
  ],
  imports: [
    CommonModule,
    MyListRoutingModule
  ]
})
export class MyListModule { }

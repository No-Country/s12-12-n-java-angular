import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchBoxComponent } from './search-box/search-box.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ShortenStringPipe } from '../layout/pipes/shorten-string.pipe';
import { SharedDividerComponent } from './shared-divider/shared-divider.component';


@NgModule({
  declarations: [
    SearchBoxComponent,
    ShortenStringPipe,
    SharedDividerComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  exports: [
    SearchBoxComponent,
    ShortenStringPipe,
    SharedDividerComponent
  ]
})
export class SharedModule { }

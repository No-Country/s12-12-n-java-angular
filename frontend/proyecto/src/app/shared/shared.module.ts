import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchBoxComponent } from './search-box/search-box.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ShortenStringPipe } from '../pipes/shorten-string.pipe';


@NgModule({
  declarations: [
    SearchBoxComponent,
    ShortenStringPipe
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  exports: [
    SearchBoxComponent,
    ShortenStringPipe
  ]
})
export class SharedModule { }

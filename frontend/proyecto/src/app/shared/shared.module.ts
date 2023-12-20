import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchBoxComponent } from './search-box/search-box.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ShortenStringPipe } from '../layout/pipes/shorten-string.pipe';
import { SharedDividerComponent } from './shared-divider/shared-divider.component';
import { SearchPipe } from '../layout/pipes/search.pipe';
import { SearchMyRecipePipe } from '../layout/pipes/search-my-recipe.pipe';


@NgModule({
  declarations: [
    SearchBoxComponent,
    ShortenStringPipe,
    SharedDividerComponent,
    SearchPipe,
    SearchMyRecipePipe
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  exports: [
    SearchBoxComponent,
    ShortenStringPipe,
    SharedDividerComponent,
    SearchPipe,
    SearchMyRecipePipe
  ]
})
export class SharedModule { }

import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-search-box',
  templateUrl: './search-box.component.html',
  styleUrls: ['./search-box.component.scss']
})
export class SearchBoxComponent {
  categories:string[] = ["Guisos", "Postres", "Ensalada", "Jugos", "Fritura"];
  sizeRecipes = 2500;
  selectedCategory="categoria";
  fieldSearch="";

  @Input() btnRedirection!:String;

  onSubmit(){
    console.log(this.selectedCategory)
  }
}

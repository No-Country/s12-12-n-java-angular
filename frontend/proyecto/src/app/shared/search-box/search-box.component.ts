import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IcategoryRes } from 'src/app/interfaces/category.interface';
import { IFilterSearch } from 'src/app/interfaces/searchFilter.interface';
import { RecipeService } from 'src/app/services/recipe.service';


@Component({
  selector: 'app-search-box',
  templateUrl: './search-box.component.html',
  styleUrls: ['./search-box.component.scss']
})
export class SearchBoxComponent {
  categories: IcategoryRes[] = [];
  @Input() sizeRecipes = 0;
  @Output() sendFilteredData = new EventEmitter<IFilterSearch>()
  selectedCategory = "categoria";
  fieldSearch = "";

  @Input() btnRedirection!: String;

  constructor(
    private recipeServ:RecipeService
  ){

  }
  ngOnInit(){
    this.recipeServ.getAllCategories().subscribe({
      next:(res)=>{
        this.categories=res;
      }
    })
  }
  onSubmit() {
    console.log(this.selectedCategory)
  }

  redirectTo() {
    if (this.btnRedirection === 'Mis recetas') {
      return "../myrecipes"
    }
    return "../createrecipe"
  }

  emit(){
    this.sendFilteredData.emit({
      searchText:this.fieldSearch,
      category:this.selectedCategory
    })
  }

}

import { Pipe, PipeTransform } from '@angular/core';
import { IrecipeResponse } from 'src/app/interfaces/receta.interface';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(
    data: IrecipeResponse[],
    searchText:string,
    category:string): IrecipeResponse[] {
    if(!data || !searchText) return data;
    searchText = searchText.toLocaleLowerCase();
    if(category === "categoria"){
      category = "";
    }
    const filteredData = data.filter(item=>{
      return (item.nombre.toLocaleLowerCase().includes(searchText) ||
        this.filterIngredients(item, searchText)) &&
        item.categoria.nombre.includes(category)
    })
    return filteredData;
  }

  private filterIngredients(
    recipe:IrecipeResponse,
    searchText:string):boolean {
    return recipe.ingredientes.some(item =>
      item.nombre
      .toLocaleLowerCase()
      .includes(searchText))
  }

}

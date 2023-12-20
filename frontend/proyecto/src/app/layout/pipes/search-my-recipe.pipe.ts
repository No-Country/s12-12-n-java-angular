import { Pipe, PipeTransform } from '@angular/core';
import { IRepositoryRes } from 'src/app/interfaces/repository.interface';

@Pipe({
  name: 'searchMyRecipe'
})
export class SearchMyRecipePipe implements PipeTransform {

  transform(
    data: IRepositoryRes[],
    searchText:string,
    category:string): IRepositoryRes[] {
    if(!data || !searchText) return data;
    searchText = searchText.toLocaleLowerCase();
    if(category === "categoria"){
      category = "";
    }
    const filteredData = data.filter(item=>{
      return (item.receta.nombre.toLocaleLowerCase().includes(searchText) ||
        this.filterIngredients(item, searchText)) &&
        item.receta.categoria.nombre.includes(category)
    })
    return filteredData;
  }

  private filterIngredients(
    recipe:IRepositoryRes,
    searchText:string):boolean {
    return recipe.receta.ingredientes.some(item =>
      item.nombre
      .toLocaleLowerCase()
      .includes(searchText))
  }

}

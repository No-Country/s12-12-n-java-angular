import { Injectable } from '@angular/core';
import { ENVIROMENT } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { IrecipeResponse } from '../interfaces/receta.interface';
import { IcategoryRes } from '../interfaces/category.interface';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private readonly APIRECIPE = ENVIROMENT.apiRecipe;
  private readonly APICATEGORY = ENVIROMENT.apiCategory
  constructor(private http:HttpClient) { }

  getAllRecipes(){
    return this.http.get<IrecipeResponse[]>(this.APIRECIPE+"/get-recetas")
  }

  getAllCategories(){
    return this.http.get<IcategoryRes[]>(this.APICATEGORY+"/get-categorias")
  }
}

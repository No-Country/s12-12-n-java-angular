import { Injectable } from '@angular/core';
import { ENVIROMENT } from '../../environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { IRecipeDTO, IrecipeResponse } from '../interfaces/receta.interface';
import { IcategoryRes } from '../interfaces/category.interface';
import { IIngredient, IIngredientDTO } from '../interfaces/ingredient.interface';
import { IRepositoryRes } from '../interfaces/repository.interface';

import { Observable, catchError, map, of, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private readonly APIRECIPE = ENVIROMENT.apiRecipe;
  private readonly APICATEGORY = ENVIROMENT.apiCategory;
  private readonly APIINGREDIENTE = ENVIROMENT.apiIngrediente;
  private readonly APIREPOSITORY = ENVIROMENT.apiRepository;

  constructor(private http:HttpClient) { }

  getAllRecipes() {
    return this.http.get<IrecipeResponse[]>(this.APIRECIPE + "/get-recetas")
  }

  getAllCategories() {
    return this.http.get<IcategoryRes[]>(this.APICATEGORY + "/get-categorias")
  }


  createRecipe(receta: IRecipeDTO) {
    return this.http.post<IrecipeResponse>(this.APIRECIPE+"/create-receta", receta);
  }

  createIngredients(ingredient: IIngredientDTO) {
    return this.http.post<string>(this.APIINGREDIENTE + "/create-ingrediente", ingredient);
  }

  getAllRecipesById(){
    return this.http.get<IRepositoryRes[]>(this.APIREPOSITORY+"/list")
  }

  deleteRecipeById(id: number) {
    return this.http.delete(this.APIREPOSITORY + "/delete?id=" + id)
  }
  updateRecipeById() {

  }
  getRecipeById(id: number): Observable<IrecipeResponse | undefined> {
    return this.http.get<IrecipeResponse>(`${this.APIRECIPE}/get-receta?id=${id}`).pipe(
      catchError((err) => of(undefined))
    )
  }
}

import { Injectable } from '@angular/core';
import { ENVIROMENT } from '../../environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { IrecipeResponse } from '../interfaces/receta.interface';
import { IcategoryRes } from '../interfaces/category.interface';
import { IRepositoryRes } from '../interfaces/repository.interface';
import { Observable, catchError, map, of, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private readonly APIRECIPE = ENVIROMENT.apiRecipe;
  private readonly APICATEGORY = ENVIROMENT.apiCategory
  private readonly APIREPOSITORY = ENVIROMENT.apiRepository
  constructor(private http: HttpClient) { }

  getAllRecipes() {
    return this.http.get<IrecipeResponse[]>(this.APIRECIPE + "/get-recetas")
  }

  getAllCategories() {
    return this.http.get<IcategoryRes[]>(this.APICATEGORY + "/get-categorias")
  }

  getAllRecipesById() {
    return this.http.get<IRepositoryRes[]>(this.APIREPOSITORY + "/list")
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

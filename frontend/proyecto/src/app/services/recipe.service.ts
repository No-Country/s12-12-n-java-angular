import { Injectable } from '@angular/core';
import { ENVIROMENT } from '../../environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IrecipeResponse } from '../interfaces/receta.interface';
import { IcategoryRes } from '../interfaces/category.interface';
import { IIngredient } from '../interfaces/ingredient.interface';
import { IRepositoryRes } from '../interfaces/repository.interface';


@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  private readonly APIRECIPE = ENVIROMENT.apiRecipe;
  private readonly APICATEGORY = ENVIROMENT.apiCategory;
  private readonly APIINGREDIENTE = ENVIROMENT.apiIngrediente;
  private readonly APIREPOSITORY = ENVIROMENT.apiRepository;

  constructor(private http:HttpClient) { }

  getAllRecipes(){
    return this.http.get<IrecipeResponse[]>(this.APIRECIPE+"/get-recetas")
  }

  getAllCategories(){
    return this.http.get<IcategoryRes[]>(this.APICATEGORY+"/get-categorias")
  }


  crearNuevaReceta(receta: IrecipeResponse): Observable<IrecipeResponse> {
    return this.http.post<IrecipeResponse>(this.APIRECIPE+"/create-receta", receta);
  }

  crearIngrediente(ingrediente: IIngredient): Observable<IIngredient> {
    return this.http.post<IIngredient>(this.APIINGREDIENTE + "/ingrediente/create-ingrediente", ingrediente);
  }
  getAllRecipesById(){
    return this.http.get<IRepositoryRes[]>(this.APIREPOSITORY+"/list")
  }

  deleteRecipeById(id:number){
    return this.http.delete(this.APIREPOSITORY+"/delete?id="+id)
  }
  updateRecipeById(){

  }
}

import { ICategory } from "./category.interface";
import { IIngredient, IIngredientCheck } from "./ingredient.interface";

export interface IrecipeResponse {
  id: number,
  nombre: string,
  procedimientos: string,
  visible: boolean,
  likes: number,
  categoria: ICategory
  ingredientes: IIngredient[],
  procedimientosArray?: string[]
}

export interface IRecipeList {
  id: number,
  name: string,
  ingredients: IIngredientCheck[]
}

export interface IRecipeDTO {
  nombre: string,
  procedimientos: string,
  visible: boolean,
  categoria: number
}

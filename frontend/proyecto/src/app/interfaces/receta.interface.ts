import { ICategory} from "./category.interface";
import { IIngredient, IIngredientCheck } from "./ingredient.interface";

export interface IrecipeResponse{
  id:string,
  nombre:string,
  procedimientos:string,
  visible:boolean,
  likes:number,
  categoria:ICategory
  ingredientes:IIngredient[]
}
export interface IRecipeList{
  id:number,
  name:string,
  ingredients:IIngredientCheck[]
}

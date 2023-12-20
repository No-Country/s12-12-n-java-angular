import { IrecipeResponse } from "./receta.interface";

export interface IUser{
  id: number;
  nombre: string;
  email: string;
  password: string;
  recetas: IrecipeResponse[];
}

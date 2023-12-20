import { IrecipeResponse } from "./receta.interface";
import { IUser } from "./user.interface";

export interface IRepositoryRes {
  id: number;
  usuario: IUser;
  receta: IrecipeResponse;
}

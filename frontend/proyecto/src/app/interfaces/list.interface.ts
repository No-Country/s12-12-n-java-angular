export interface IListDataRoute{
  recipes:string[],
  ingredients:string[]
}

export interface IListIngredient{
  id:number,
  ingredient:string,
  status:string
}
export interface IListDTO extends IListDataRoute{
  createdAt : Date;
}

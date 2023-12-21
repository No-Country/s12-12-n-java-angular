export interface IIngredient{
  id:number,
  nombre:string,
  cantidad:number,
  tipo_medida:string
}
export interface IIngredientEmit extends IIngredient{
  action : string
}

export interface IIngredientCheck extends IIngredient{
  isCheck:boolean
}

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
export interface IIngredientDTO
  extends Omit<IIngredient, "id">{
    recetaId:number
  }
export interface IIngredientRes
  extends Omit<IIngredient, "id">{}

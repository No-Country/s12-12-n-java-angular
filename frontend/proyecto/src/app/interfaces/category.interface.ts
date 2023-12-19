
export interface ICategory{
  id:number
  nombre:string
}
export interface IcategoryRes extends Omit<ICategory, 'id'> {}

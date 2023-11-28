import { AbstractControl } from '@angular/forms';
/**
 * Validaciones
 * expacios excesivos
 * Minimo 5 caracteres
 * Maximo 40 caracteres
 * No permite que el primer digito sea un espacio en blanco
 * No permite mas de 2 esoaciso entre palabras
 * @param controller
 * @returns nulo o error
 */
export function textValidator(controller: AbstractControl) {
  const specialCharacter = /[^a-zA-Z0-9á-ýÁ-Ý-_\s]/g;
  const spaces = /(\s{2,})/g;

  const value = controller.value as string;

  if (value.length < 5) {
    return { minLength: true, message: 'Mínimo 5 carácteres.' };
  }
  if (specialCharacter.test(value)) {
    return {
      invalidChar: true,
      message: 'Solo se permite - _ como carácteres especiales.',
    };
  }
  if (/^\s/g.test(value)) {
    return {
      hasFirstSpace: true,
      message: 'El primer caracter no puede ser un espacio.',
    };
  }
  if (spaces.test(value)) {
    return { hasSpaces: true, message: 'Espacios excesivos' };
  }
  if (value.length > 40) {
    return { maxLength: true, message: 'Máximo 40 carácteres.' };
  }
  return null;
}
/**
 * Valida los correos, para  encontrar del @
 *  seguido de un punto y de 2 a 4 caracteres
 * @param controller
 * @returns nulo o error
 */
export function emailValidator(controller: AbstractControl) {
  const emailPattern = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
  const value = controller.value as string;

  if (!emailPattern.test(value)) {
    return { emailInvalid: true, message: 'Formato inválido.' };
  }
  return null;
}


/**
 * La contraseña tiene minimo, 1 numero, 9 caracteres, 1 minuscula
 * 1 mayuscula y maximo 20 caracteres.
 * @param controller
 * @returns nulo o error
*/
export function passValidator(controller: AbstractControl) {
  const value = controller.value as string;
  const passPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]+$/g;
  if (value.length < 9) {
    return { minLength: true, message: 'Mínimo 9 carácteres.' };
  }
  if (/^[^\d]+$/.test(value)) {
    return { notNumber: true, message: 'Minimo 1 número.' };
  }
  if (/^[^A-Z]+$/.test(value)) {
    return { notUpper: true, message: 'Minimo 1 mayúscula.' };
  }
  if (/^[^a-z]+$/.test(value)) {
    return { notLower: true, message: 'Minimo 1 minuscula.' };
  }
  if (!passPattern.test(value)) {
    return { invalid: true, message: 'Formato inválido.' };
  }
  if (value.length > 20) {
    return { maxLength: true, message: 'Máximo 20 carácteres.' };
  }
  return null;
}

/**
 * Valida que el contenido sea el mismo que password
 * @param controller
 * @returns nulo o error
*/
export function repeatPassValidator(controller: AbstractControl) {
  const pass: string = controller.root.get('password')?.value;
  const repeatPass: string = controller.value;

  if (pass !== repeatPass) {
    return { noMatch: true, message: 'Las contraseñas deben coincidir.' };
  }
  return null;
}

// export function passValidator(controller:AbstractControl){
//   const value = controller.value as string;
//   const passPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[-_+|!@#$%^&*\.])[A-Za-z\d-_+|¡!@#$%^&*\.]+$/g;
//   if(value.length < 9){
//     return {minLength:true, message:'Mínimo 9 carácteres.'}
//   }
//   if(/^[^\d]+$/.test(value)){
//     return {notNumber:true, message:'Minimo 1 número.'}
//   }
//   if(/^[^A-Z]+$/.test(value)){
//     return {notUpper:true, message:'Minimo 1 mayúscula.'}
//   }
//   if(/^[^a-z]+$/.test(value)){
//     return {notLower:true, message:'Minimo 1 minuscula.'}
//   }
//   if(/^[^-_+|¡!@#$%^&*\.]+$/.test(value)){
//     return {notChar:true, message:'Minimo 1 cáracter -_+|¡!@#$%^&*. .'}
//   }
//   if(!passPattern.test(value)){
//     return {invalid:true, message:'Formato inválido.'}
//   }
//   if(value.length > 20){
//     return {maxLength:true, message:'Máximo 20 carácteres.'}
//   }
//   return null
// };

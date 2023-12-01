import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { emailValidator, passValidator, repeatPassValidator, textValidator } from 'src/app/customValidators/customValidators';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss'],
})
export class UserComponent {
  username = 'Emanuel '; //prueba de username
  imageUrl = 'https://this-is-an-invalid-url.com/invalid-image.jpg'; //prueba de imagen que no carga
  imageError = false;
// agregar loader spinner
  onImageError() {
    this.imageError = true;
    console.log('La función onImageError se ha ejecutado.');
  }
  registForm!: FormGroup;
  showPass = false;
  showRepeatPass = false;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.registForm = this.initForm();
  }

  /**
   * registra el nuevo usuario
   */
  onSubmit() {
    console.log(this.registForm)

  }

  /**
   * Verifica si el campo tiene error despues de haber sido tocado.
   *@param string:campo
  */
  invalidateField(field:string){
    return ( this.registForm.get(field)?.errors &&
     this.registForm.get(field)?.touched);
  }

  /**
   * retorna el mensaje de error de la validacion.
   *@param string:campo
  */
  validationFieldMessage(field:string):string{
    return (this.registForm.get(field)?.errors?.['message'])
  }

  /**
   * crea un formulario para registrar usuarios
   * @returns retorna un formGroup
   */
  initForm() {
    return this.fb.group({
      username: ['', [Validators.required, textValidator]],
      password: ['', [Validators.required, passValidator]],
      repeatPassword: ['',[Validators.required, repeatPassValidator, passValidator]],
      email: ['',[ Validators.required, emailValidator]],
    });
  }
}

import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import {
  emailValidator,
  passValidator,
  repeatPassValidator,
  textValidator,
} from 'src/app/customValidators/customValidators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {

  // quitar el ojo del edge
  loginForm!: FormGroup;
  showPass = false;
  rememberMe : boolean = false;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.loginForm = this.initLoginForm();
  }

  login() {
    console.log(this.loginForm);

    if (this.rememberMe) {
      this.rememberMe = true;
      console.log('recordarme');
    } else {
      this.rememberMe = false;
    }


  }

  //Reutilizo codigo del register

  /**
   * Verifica si el campo tiene error despues de haber sido tocado.
   *@param string:campo
  */
   invalidateField(field:string){
    return ( this.loginForm.get(field)?.errors &&
     this.loginForm.get(field)?.touched);
  }

  /**
   * retorna el mensaje de error de la validacion.
   *@param string:campo
  */
  validationFieldMessage(field:string):string{
    return (this.loginForm.get(field)?.errors?.['message'])
  }


  /**
   * crea un formulario para el inicio de sesión
   * @returns retorna un formGroup
   */
  initLoginForm() {
    return this.fb.group({
      email: ['', [Validators.required, emailValidator]],
      password: ['', [Validators.required, passValidator]],
    });
  }
}

import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {
  emailValidator,
  passValidator,
  repeatPassValidator,
  textValidator,
} from 'src/app/customValidators/customValidators';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss'],
})
export class EditUserComponent {
  userForm!: FormGroup;
  showPass = false;
  showRepeatPass = false;

  constructor(private fb: FormBuilder, private router: Router) {}

  ngOnInit() {
    this.userForm = this.initForm();
  }

  /**
   * registra el nuevo usuario
   */
  onSubmit() {
    console.log(this.userForm);
  }

  /**
   * Verifica si el campo tiene error despues de haber sido tocado.
   *@param string:campo
   */
  invalidateField(field: string) {
    return (
      this.userForm.get(field)?.errors && this.userForm.get(field)?.touched
    );
  }

  /**
   * retorna el mensaje de error de la validacion.
   *@param string:campo
   */
  validationFieldMessage(field: string): string {
    return this.userForm.get(field)?.errors?.['message'];
  }

  /**
   * crea un formulario para registrar usuarios
   * @returns retorna un formGroup
   */
  initForm() {
    return this.fb.group({
      username: ['', [Validators.required, textValidator]],
      password: ['', [Validators.required, passValidator]],
      repeatPassword: ['', [Validators.required, repeatPassValidator, passValidator]],
      email: ['', [Validators.required, emailValidator]],
    });
  }
}

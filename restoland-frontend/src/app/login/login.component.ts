import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  disabledSubmit:boolean = true;

  loginForm = new FormGroup({
    email: new FormControl('', [Validators.email, Validators.required]),
    userpassword: new FormControl('', Validators.required)
  })


  ngOnInit() {
    this.validacionFormulario();
    
  }

  validacionFormulario():void{
    this.loginForm.statusChanges.subscribe(value => {
      if(this.loginForm.status === "VALID")
        this.disabledSubmit = false;
      else
        this.disabledSubmit = true;
    });
  }
}

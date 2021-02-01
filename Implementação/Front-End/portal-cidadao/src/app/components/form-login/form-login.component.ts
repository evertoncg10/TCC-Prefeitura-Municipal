import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { Usuario } from 'src/app/models/Usuario';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.css']
})
export class FormLoginComponent implements OnInit {

  public usuario: Usuario = new Usuario();
  returnUrl: string;
  error = '';

  constructor(private router: Router,
    private activatedRoute: ActivatedRoute,
    private loginService: LoginService) { }

  ngOnInit(): void {
    this.error = this.activatedRoute.snapshot.queryParams['message'] || '';
  }

  login() {
    if (this.validaCamposUsuario()) {
      this.loginService.login(this.usuario)
        .pipe(first())
        .subscribe(() => {
          this.router.navigate(['portal/home']);
        }, error => {
          this.error = error;
        });
    }
  }

  validaCamposUsuario() {
    if((this.usuario.username == null || this.usuario.username === '') 
        && (this.usuario.password == null || this.usuario.password == null)) {
      this.error = 'Os campos devem ser preenchidos';
      return false;
    } else if(this.usuario.username == null || this.usuario.username === '') {
      this.error = 'O campo usuário é obrigatório';
      return false;
    } else if(this.usuario.password == null || this.usuario.password == null) {
      this.error = 'O campo senha é obrigatório';
      return false;
    }
    return true;
  }

}

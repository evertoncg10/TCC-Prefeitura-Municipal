import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Usuario } from '../models/Usuario';
import { UsuarioLogado } from '../models/UsuarioLogado';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private currentUserSubject : BehaviorSubject<UsuarioLogado>;
  public currentUser: Observable<UsuarioLogado>;

  constructor(private httpClient: HttpClient) { 
    this.currentUserSubject = new BehaviorSubject<UsuarioLogado>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserLogged(): UsuarioLogado {
    return this.currentUserSubject.value;
  }

  login(usuario: Usuario) {
    let usuarioLogado = new UsuarioLogado();
    usuarioLogado.username = usuario.username;
    return this.httpClient.post<UsuarioLogado>(environment.apiAuth, usuario)
    .pipe(map(logged => {
      if(logged) {
        localStorage.setItem('currentUser', JSON.stringify(logged));
        this.currentUserSubject.next(logged);
        return logged;
      }
    }));
  }

  logout() {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}

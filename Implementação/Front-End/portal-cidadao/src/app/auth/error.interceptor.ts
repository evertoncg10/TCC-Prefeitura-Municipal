import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { LoginService } from '../services/login.service';
import { catchError } from 'rxjs/operators';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

  constructor(private loginService: LoginService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(catchError(err => {
      let error;
      if(err.status === 401) {
        this.loginService.logout();
        error = 'Usuário ou senha inválidos';
      } else if(err.status === 404) {
        this.loginService.logout();
        error = 'Usuário não encontrado';
      }

      if(!error) {
        error = err.error.message || err.statusText;
      }
      return throwError(error);
    }));
  }
}

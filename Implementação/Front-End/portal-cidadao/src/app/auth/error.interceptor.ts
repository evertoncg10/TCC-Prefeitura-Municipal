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
import { Router } from '@angular/router';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

  constructor(private router: Router, private loginService: LoginService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(catchError(err => {
      let error;
      if(err.status === 401) {
        this.loginService.logout();
        const errorObject = err.error;
        if(errorObject.error === 'Unauthorized') {
          error = 'Usuário ou senha inválidos';
        }
      }
      if(!error) {
        error = err.error || err.statusText;
      }
      this.router.navigate(['login'], { queryParams: { message: error } } );
      return throwError(error);
    }));
  }
}

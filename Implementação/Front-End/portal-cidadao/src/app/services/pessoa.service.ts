import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private httpClient: HttpClient) { }

  getPessoaByEmail(email: string) {
    return this.httpClient.get<any>(`${environment.apiCidadao}?email=${email}`);
  }
}

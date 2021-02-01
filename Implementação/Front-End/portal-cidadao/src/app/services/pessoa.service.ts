import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PessoaFisica } from '../models/PessoaFisica';
import { PessoaJuridica } from '../models/PessoaJuridica';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private httpClient: HttpClient) { }

  getPessoaByEmail(email: string) {
    return this.httpClient.get<any>(`http://localhost:8080/pessoas?email=${email}`);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImovelService {

  constructor(private httpClient: HttpClient) { }

  getImoveis(cpfCnpj) {
    return this.httpClient.get<any>(`http://localhost:8060/pessoas/${cpfCnpj}/imoveis`);
  }
}

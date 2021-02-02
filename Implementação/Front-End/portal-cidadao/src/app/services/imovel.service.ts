import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ImovelService {

  constructor(private httpClient: HttpClient) { }

  getImoveis(cpfCnpj) {
    return this.httpClient.get<any>(`${environment.apiImovel}/${cpfCnpj}/imoveis`);
  }
}

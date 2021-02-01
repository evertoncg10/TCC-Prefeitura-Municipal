import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pessoa } from 'src/app/models/Pessoa';
import { PessoaFisica } from 'src/app/models/PessoaFisica';
import { PessoaJuridica } from 'src/app/models/PessoaJuridica';
import { ImovelService } from 'src/app/services/imovel.service';

@Component({
  selector: 'app-consulta-imoveis',
  templateUrl: './consulta-imoveis.component.html',
  styleUrls: ['./consulta-imoveis.component.css']
})
export class ConsultaImoveisComponent implements OnInit {

  constructor(private imovelService: ImovelService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  public pessoa: PessoaFisica | PessoaJuridica | Pessoa;
  public isPessoaFisica: boolean;
  public titulo: string;

  ngOnInit(): void {
    if(!this.pessoa) {
      this.pessoa = new Pessoa();
    }
    this.carregarImoveisUsuario();
  }

  carregarImoveisUsuario() {
    this.activatedRoute.params.subscribe(params => {
      this.imovelService.getImoveis(params['cpfCnpj']).subscribe(data => {
        this.pessoa = data;
        this.isPessoaFisica = data.cpf;
        this.titulo = this.isPessoaFisica ? 'Dados do Cidadão' : 'Dados da Empresa';
      })
    });
  }

}

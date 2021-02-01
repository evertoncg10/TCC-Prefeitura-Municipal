import { Component, Input, OnInit } from '@angular/core';
import { PessoaJuridica } from 'src/app/models/PessoaJuridica';

@Component({
  selector: 'app-painel-pessoa-juridica',
  templateUrl: './painel-pessoa-juridica.component.html',
  styleUrls: ['./painel-pessoa-juridica.component.css']
})
export class PainelPessoaJuridicaComponent implements OnInit {

  constructor() { }

  @Input() pessoaJuridica: PessoaJuridica;

  ngOnInit(): void {
    if(!this.pessoaJuridica) this.pessoaJuridica = new PessoaJuridica();
  }

}

import { Component, Input, OnInit } from '@angular/core';
import { PessoaFisica } from 'src/app/models/PessoaFisica';

@Component({
  selector: 'app-painel-pessoa-fisica',
  templateUrl: './painel-pessoa-fisica.component.html',
  styleUrls: ['./painel-pessoa-fisica.component.css']
})
export class PainelPessoaFisicaComponent implements OnInit {

  constructor() { }

  @Input() pessoaFisica: PessoaFisica;

  ngOnInit(): void {
    if(!this.pessoaFisica) {
      this.pessoaFisica = new PessoaFisica();
    }
  }

}

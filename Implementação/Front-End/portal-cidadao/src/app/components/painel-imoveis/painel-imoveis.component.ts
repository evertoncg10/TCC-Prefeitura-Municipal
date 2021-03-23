import { Component, Input, OnInit } from '@angular/core';
import { Imovel } from 'src/app/models/Imovel';

@Component({
  selector: 'app-painel-imoveis',
  templateUrl: './painel-imoveis.component.html',
  styleUrls: ['./painel-imoveis.component.css']
})
export class PainelImoveisComponent implements OnInit {

  constructor() { }

  @Input() imoveis: Imovel[];

  ngOnInit(): void {
  }

}

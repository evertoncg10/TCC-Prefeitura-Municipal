import { Component, Input, OnInit } from '@angular/core';
import { Endereco } from 'src/app/models/Endereco';

@Component({
  selector: 'app-endereco',
  templateUrl: './endereco.component.html',
  styleUrls: ['./endereco.component.css']
})
export class EnderecoComponent implements OnInit {

  constructor() { }

  @Input()
  endereco: Endereco;

  ngOnInit(): void {
    if(!this.endereco) {
      this.endereco = new Endereco();
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { PessoaFisica } from 'src/app/models/PessoaFisica';
import { PessoaJuridica } from 'src/app/models/PessoaJuridica';
import { PessoaService } from 'src/app/services/pessoa.service';

@Component({
  selector: 'app-servicos-home-portal',
  templateUrl: './servicos-home-portal.component.html',
  styleUrls: ['./servicos-home-portal.component.css']
})
export class ServicosHomePortalComponent implements OnInit {

  public isCidadao: boolean = true;
  public nomeUsuario: string;
  private cpfCnpj;
  constructor(private router: Router, 
              private pessoaService: PessoaService) { }

  ngOnInit(): void {
    this.loadUser(); 
  }

  loadUser() {
    const usuario = JSON.parse(localStorage.getItem('currentUser'));

    this.pessoaService.getPessoaByEmail(usuario.username)
      .pipe(first())
      .subscribe(pessoa => {
        if(pessoa.cpf) {
          this.nomeUsuario = pessoa.nome;
          this.cpfCnpj = pessoa.cpf;
          this.isCidadao = pessoa.tipo && pessoa.tipo === 'CIDADAO';
        } else {
          this.cpfCnpj = pessoa.cnpj;
          this.nomeUsuario = pessoa.razaoSocial;
        }
      });
  }

  consultarImposto(){
    this.router.navigate([`/portal/imoveis/${this.cpfCnpj}`]);
  }

}

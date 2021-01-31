import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ACidadeComponent } from './views/a-cidade/a-cidade.component';
import { Covid19Component } from './views/covid19/covid19.component';
import { HomeComponent } from './views/home/home.component';
import { LoginComponent } from './views/login/login.component';
import { ConsultaImoveisComponent } from './views/portal/consulta-imoveis/consulta-imoveis.component';
import { HomePortalComponent } from './views/portal/home-portal/home-portal.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'a-cidade', component: ACidadeComponent},
  {path: 'covid-19', component: Covid19Component},
  {path: 'portal/home', component: HomePortalComponent},
  {path: 'portal/imoveis', component: ConsultaImoveisComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

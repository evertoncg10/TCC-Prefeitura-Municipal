import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BannerHomeComponent } from './components/banner-home/banner-home.component';
import { FormLoginComponent } from './components/form-login/form-login.component';
import { NoticiasComponent } from './components/noticias/noticias.component';
import { PainelImoveisComponent } from './components/painel-imoveis/painel-imoveis.component';
import { PainelPessoaFisicaComponent } from './components/painel-pessoa-fisica/painel-pessoa-fisica.component';
import { PainelPessoaJuridicaComponent } from './components/painel-pessoa-juridica/painel-pessoa-juridica.component';
import { ServicosHomePortalComponent } from './components/servicos-home-portal/servicos-home-portal.component';
import { ACidadeComponent } from './views/a-cidade/a-cidade.component';
import { HomeComponent } from './views/home/home.component';
import { LoginComponent } from './views/login/login.component';
import { ConsultaImoveisComponent } from './views/portal/consulta-imoveis/consulta-imoveis.component';
import { HomePortalComponent } from './views/portal/home-portal/home-portal.component';
import { PortalHeaderComponent } from './views/portal/portal-header/portal-header.component';
import { FooterComponent } from './views/template/footer/footer.component';
import { HeaderComponent } from './views/template/header/header.component';
import { TituloComponent } from './views/template/titulo/titulo.component';
import { Covid19Component } from './views/covid19/covid19.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    NoticiasComponent,
    BannerHomeComponent,
    LoginComponent,
    FormLoginComponent,
    HomePortalComponent,
    ServicosHomePortalComponent,
    ConsultaImoveisComponent,
    PainelPessoaFisicaComponent,
    PainelPessoaJuridicaComponent,
    TituloComponent,
    PainelImoveisComponent,
    PortalHeaderComponent,
    ACidadeComponent,
    Covid19Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

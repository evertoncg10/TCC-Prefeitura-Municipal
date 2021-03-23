import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import localePt from '@angular/common/locales/pt';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BannerHomeComponent } from './components/banner-home/banner-home.component';
import { FormLoginComponent } from './components/form-login/form-login.component';
import { NoticiasComponent } from './components/noticias/noticias.component';
import { PainelPessoaFisicaComponent } from './components/painel-pessoa-fisica/painel-pessoa-fisica.component';
import { PainelPessoaJuridicaComponent } from './components/painel-pessoa-juridica/painel-pessoa-juridica.component';
import { ServicosHomePortalComponent } from './components/servicos-home-portal/servicos-home-portal.component';
import { HomeComponent } from './views/home/home.component';
import { LoginComponent } from './views/login/login.component';
import { ConsultaImoveisComponent } from './views/portal/consulta-imoveis/consulta-imoveis.component';
import { HomePortalComponent } from './views/portal/home-portal/home-portal.component';
import { FooterComponent } from './views/template/footer/footer.component';
import { HeaderComponent } from './views/template/header/header.component';
import { TituloComponent } from './views/template/titulo/titulo.component';
import { PainelImoveisComponent } from './components/painel-imoveis/painel-imoveis.component';
import { PortalHeaderComponent } from './views/portal/portal-header/portal-header.component';
import { ACidadeComponent } from './views/a-cidade/a-cidade.component';
import { FormsModule } from '@angular/forms';
import { CpfPipe } from './pipes/cpf.pipe';
import { CnpjPipe } from './pipes/cnpj.pipe';
import { PhonePipe } from './pipes/phone.pipe';
import { InscricaoEstadualPipe } from './pipes/inscricao-estadual.pipe';
import { EnderecoComponent } from './components/endereco/endereco.component';
import { InscricaoMunicipalPipe } from './pipes/inscricao-municipal.pipe';
import { registerLocaleData } from '@angular/common';
import { CepPipe } from './pipes/cep.pipe';
import { JwtInterceptor } from './auth/jwt.interceptor';
import { ErrorInterceptor } from './auth/error.interceptor';
import { LoaderModule } from './modules/loader/loader.module';
import { LoaderInterceptor } from './auth/loader.interceptor';
import { Covid19Component } from './views/covid19/covid19.component';

registerLocaleData(localePt);

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
    CpfPipe,
    CnpjPipe,
    PhonePipe,
    InscricaoEstadualPipe,
    EnderecoComponent,
    InscricaoMunicipalPipe,
    CepPipe,
    Covid19Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    LoaderModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt-BR' },
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: LoaderInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

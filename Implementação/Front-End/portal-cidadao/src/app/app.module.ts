import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BannerHomeComponent } from './components/banner-home/banner-home.component';
import { FormLoginComponent } from './components/form-login/form-login.component';
import { NoticiasComponent } from './components/noticias/noticias.component';
import { ServicosHomePortalComponent } from './components/servicos-home-portal/servicos-home-portal.component';
import { HomeComponent } from './views/home/home.component';
import { LoginComponent } from './views/login/login.component';
import { HomePortalComponent } from './views/portal/home-portal/home-portal.component';
import { FooterComponent } from './views/template/footer/footer.component';
import { HeaderComponent } from './views/template/header/header.component';

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
    ServicosHomePortalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

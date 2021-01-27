import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './views/template/header/header.component';
import { FooterComponent } from './views/template/footer/footer.component';
import { HomeComponent } from './views/home/home.component';
import { NoticiasComponent } from './components/noticias/noticias.component';
import { BannerHomeComponent } from './components/banner-home/banner-home.component';
import { LoginComponent } from './views/login/login.component';
import { FormLoginComponent } from './components/form-login/form-login.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    NoticiasComponent,
    BannerHomeComponent,
    LoginComponent,
    FormLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

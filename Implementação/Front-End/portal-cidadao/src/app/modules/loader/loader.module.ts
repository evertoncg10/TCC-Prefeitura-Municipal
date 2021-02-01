import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoaderComponent } from 'src/app/components/loader/loader.component';
import { NgxLoadingModule } from 'ngx-loading';



@NgModule({
  declarations: [LoaderComponent],
  exports: [LoaderComponent],
  imports: [
    CommonModule,
    NgxLoadingModule.forRoot({
      fullScreenBackdrop: true
    })
  ]
})
export class LoaderModule { }

import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'inscricaoMunicipal'
})
export class InscricaoMunicipalPipe implements PipeTransform {

  transform(value: string, ...args: any[]): any {
    if(!value) {
      return null;
    }
    if(value.length == 10){
      return value.replace(/(\d{3})(\d{3})(\d{3})(\d{1})/g, '\$1.\$2.\$3-\$4');
    }
    return 'error';
  }

}

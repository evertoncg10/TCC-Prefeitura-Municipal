import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ieMG'
})
export class InscricaoEstadualPipe implements PipeTransform {

  transform(value: string, ...args: any[]): any {
    if(!value) {
      return null;
    }
    if(value.length == 13){
      return value.replace(/(\d{3})(\d{3})(\d{3})(\d{4})/g, '\$1.\$2.\$3/\$4');
    }
    return 'error';
  }

}

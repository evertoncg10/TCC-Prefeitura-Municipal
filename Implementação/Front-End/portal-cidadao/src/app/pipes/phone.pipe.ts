import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'phone'
})
export class PhonePipe implements PipeTransform {

  transform(value: string, ...args: any[]): any {
    if (value) {
      const format = '(\$1) \$2-\$3';
      let regex;
      if (value.length == 10) {
        regex = /(\d{2})(\d{4})(\d{4})/g;
      } else if (value.length == 11) {
        regex = /(\d{2})(\d{5})(\d{4})/g;
      }
      return value.replace(regex, format);
    } else {
      return null;
    }
  }

}

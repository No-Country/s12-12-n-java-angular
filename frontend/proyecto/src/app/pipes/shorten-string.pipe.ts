import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'shortenString'
})
export class ShortenStringPipe implements PipeTransform {
  /**
   * Este pipe cambia longitud de los string sustiyuendo por puntos...
   * @param args limite a partir del cual se aplicara, por defaul 10
   *
  */
  transform(value: string, args?: number): string {
    const limit = args ?? 15;
    return value.substring(0, limit)+"...";
  }

}

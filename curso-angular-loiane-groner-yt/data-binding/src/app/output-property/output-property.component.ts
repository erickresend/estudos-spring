import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'contador',
  templateUrl: './output-property.component.html',
  styleUrl: './output-property.component.css'
})
export class OutputPropertyComponent {

  @Input() valor = 0;

  @Output() mudouValor = new EventEmitter;

  incrementa(){
    this.valor++;
    this.mudouValor.emit({novoValor: this.valor});
  }

  decrementa(){
    this.valor--;
    this.mudouValor.emit({novoValor: this.valor});
  }

  onMudouValor(evento: any){
    console.log(evento);
  }
}

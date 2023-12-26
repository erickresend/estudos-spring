import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-curso',
  templateUrl: './input-property.component.html',
  styleUrl: './input-property.component.css'
})
export class InputPropertyComponent {

  @Input() nome: string = '';
}

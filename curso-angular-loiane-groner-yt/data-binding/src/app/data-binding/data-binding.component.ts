import { Component } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrl: './data-binding.component.css'
})
export class DataBindingComponent {

  url: string = "http://loiane.com";
  cursoAngular: boolean = true;
  urlImagem = "https://ihg.scene7.com/is/image/ihg/ihg-trip-ideas-lp-home-featured-nyc-400x200"

  valorAtual = '';
  valorSalvo: any = '';
  isMouseOver = false;

  nome: string = "abc";

  pessoa: any = {
    nome: "def",
    idade: 20
  }

  getValor(){
    return 1;
  }

  getCurtirCurso(){
    return true;
  }

  botaoClicado(){
    alert("Botão clicado!")
  }

  onKeyUp(evento: KeyboardEvent){
    this.valorAtual = ((<HTMLInputElement>evento.target).value);
  }

  salvarValor(valor: any){
    this.valorSalvo = valor;
  }

  onMouseOverOut(){
    this.isMouseOver = !this.isMouseOver;
  }
}

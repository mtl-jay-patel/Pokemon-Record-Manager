import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Pokemon } from './pokemon';
import { PokemonService } from './pokemon.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public pokemons: Pokemon[] = [];
  public editPokemon: Pokemon | null | undefined;
  public deletePokemon: Pokemon | null | undefined;
  


  constructor(private pokemonService: PokemonService) { }

  ngOnInit(): void {
    this.getPokemons();
  }

  public getPokemons(): void {
    this.pokemonService.getPokemons().subscribe(
      (response: Pokemon[]) => {
        this.pokemons = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddPokemon(addForm: NgForm): void {
    document.getElementById('add-pokemon-form')?.click();
    this.pokemonService.addPokemon(addForm.value).subscribe(
      (response: Pokemon) => {
        console.log(response);
        this.getPokemons(); //reload 
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

    public onUpdatePokemon(pokemon: Pokemon): void {
    this.pokemonService.updatePokemon(pokemon).subscribe(
      (response: Pokemon) => {
        console.log(response);
        this.getPokemons(); //reload 
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeletePokemon(pokemonId: number): void {
    this.pokemonService.deletePokemon(pokemonId).subscribe(
      (response: void) => {
        console.log(response);
        this.getPokemons();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public searchPokemon(key: string):void {
    const results: Pokemon[] = [];
    for (const pokemon of this.pokemons) {
      if (pokemon.name.toLowerCase().indexOf(key.toLowerCase()) !== -1 
      || pokemon.ability.toLowerCase().indexOf(key.toLowerCase()) !== -1 
      || pokemon.move1.toLowerCase().indexOf(key.toLowerCase()) !== -1 
      || pokemon.move2.toLowerCase().indexOf(key.toLowerCase()) !== -1 
      || pokemon.move3.toLowerCase().indexOf(key.toLowerCase()) !== -1 
      || pokemon.move4.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(pokemon);
      }
    }
    this.pokemons = results;
    if (results.length === 0 || !key) {
      this.getPokemons();
    }
  }

  public onOpenModal(pokemon: Pokemon | null, mode: string): void {
    const container = document.getElementById('main-container'); 
    const button = document.createElement('button'); 
    button.type = 'button';
    button.style.display = 'none'; 
    button.setAttribute('data-toggle', 'modal'); 
    if (mode === 'add') {
      button.setAttribute('data-target', '#addPokemonModal');
    }
    if (mode === 'edit') {
      this.editPokemon = pokemon;
      button.setAttribute('data-target', '#updatePokemonModal');
    }
    if (mode === 'delete') {
      this.deletePokemon = pokemon;
      button.setAttribute('data-target', '#deletePokemonModal');
    }
    container?.appendChild(button); 
    


  }


}

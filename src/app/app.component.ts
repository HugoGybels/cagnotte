import * as moment from 'moment';
import { Moment } from 'moment';
import { Component, OnInit } from '@angular/core';
import { Partie } from './model/partie.model';
import { Resultat } from './model/resultat.model';
import { Utilisateur } from './model/utilisateur.model';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.scss' ]
})
export class AppComponent implements OnInit {
  
  public sommeTotale = 0;
  public parties: Partie[] = [];
  
  constructor() {
    this.parties.push(this.initPartie(1));
    this.parties.push(this.initPartie(2));
    this.parties.push(this.initPartie(3));
  }

  public ngOnInit() {
    this.calculateSommeTotale();
  }

  private calculateSommeTotale() {
    this.parties.forEach(partie => {
      partie.resultats
        .filter(r => r.joueurPreneur !== undefined && r.joueurPreneur.nom === 'CAGNOTTE')
        .forEach( r => this.sommeTotale += r.somme);
    });
  }

  private initPartie(i: number): Partie {
    return new Partie({
        typePartie: 'Deploisat ' + i,
        //date: moment('2019-08-26'),
        nombreJoueurs: 4,
        resultats: [
          new Resultat ({
            somme: 20,
            joueurDonneur: new Utilisateur ({
              nom: 'Bonnevialle',
              prenom: 'Théo'
            }),
            joueurPreneur: new Utilisateur ({
              nom: 'CAGNOTTE',
              prenom: 'CAGNOTTE'
            }),
            position: 3
          }),
          new Resultat ({
            somme: 20,
            joueurDonneur: new Utilisateur ({
              nom: 'Salignat',
              prenom: 'Corentin'
            }),
            joueurPreneur: new Utilisateur ({
              nom: 'CAGNOTTE',
              prenom: 'CAGNOTTE'
            }),
            position: 4
          }),
          new Resultat ({
            somme: 5,
            joueurDonneur: new Utilisateur ({
              nom: 'Muret',
              prenom: 'Alexis'
            }),
            joueurPreneur: new Utilisateur ({
              nom: 'Gybels',
              prenom: 'Hugo'
            }),
            position: 2
          }),
          new Resultat ({
            somme: 0,
            joueurDonneur: new Utilisateur ({
              nom: 'Gybels',
              prenom: 'Hugo'
            }),
            position: 1
          })
        ]
      });
  }
}

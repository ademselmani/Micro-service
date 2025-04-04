import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';

@Component({
  selector: 'app-bloc',
  templateUrl: './bloc.component.html',
  styleUrls: ['./bloc.component.css']
})
export class BlocComponent implements OnInit {
  blocs: any[] = [];
  nomBloc: string = '';
  capaciteBloc: string = '';
  isFiltered: boolean = false;
  isAdding: boolean = false; // Gérer l'affichage du formulaire d'ajout
  newBloc = { nomBloc: '', capaciteBloc: '' }; // Stocker les données du nouveau bloc

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.getAllBlocs();
  }

  // Récupérer tous les blocs
  getAllBlocs(): void {
    this.apiService.getAllBlocs().subscribe((data: any) => {
      this.blocs = data;
    });
  }

  // Filtrer les blocs selon les critères nomBloc et capaciteBloc
  filterBlocs(): void {
    this.apiService.filterBlocs(this.nomBloc, this.capaciteBloc).subscribe((data) => {
      console.log('Données retournées après filtrage:', data);
      this.blocs = data;
      this.isFiltered = true;
    }, error => {
      console.error('Erreur lors du filtrage des blocs:', error);
    });
  }

//   // Supprimer un bloc
//   deleteBloc(blocId: number): void {
//     this.apiService.deleteBloc(blocId).subscribe(
//       (response) => {
//         this.blocs = this.blocs.filter(bloc => bloc.idBloc !== blocId);
//       },
//       (error) => {
//         console.error('Erreur lors de la suppression du bloc', error);
//       }
//     );
//   }

//   // Afficher/Masquer le formulaire d'ajout
//   toggleAddForm(): void {
//     this.isAdding = !this.isAdding;
//     if (!this.isAdding) {
//       this.newBloc = { nomBloc: '', capaciteBloc: '' };
//     }
//   }

//   // Ajouter un nouveau bloc
//   addBloc(): void {
//     this.apiService.addBloc(this.newBloc).subscribe(
//       (response) => {
//         this.blocs.push(response); // Ajouter le bloc à la liste
//         this.toggleAddForm(); // Masquer le formulaire après ajout
//       },
//       (error) => {
//         console.error('Erreur lors de l\'ajout du bloc', error);
//       }
//     );
//   }
}

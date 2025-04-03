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

  // Mettre à jour un bloc (Exemple: vous pouvez ouvrir un formulaire pour la mise à jour)
  updateBloc(bloc: any): void {
    console.log('Mise à jour du bloc:', bloc);
    // Logique de mise à jour
    // Vous pouvez afficher un formulaire de mise à jour ou appeler une méthode du service pour mettre à jour le bloc
  }

  // Supprimer un bloc
  deleteBloc(bloc: any): void {
    console.log('Suppression du bloc:', bloc);
    // Appel de la méthode du service pour supprimer le bloc
    this.apiService.deleteBloc(bloc.id).subscribe(() => {
      console.log('Bloc supprimé');
      // Retirer le bloc de la liste après suppression
      this.blocs = this.blocs.filter(item => item.id !== bloc.id);
    }, error => {
      console.error('Erreur lors de la suppression du bloc:', error);
    });
  }
}

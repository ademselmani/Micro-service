import { Component, OnInit } from '@angular/core';
import { FoyerService, Foyer, Foyerr } from '../../services/foyer.service';

@Component({
  selector: 'app-foyer-list',
  templateUrl: './foyer-list.component.html',
})
export class FoyerListComponent implements OnInit {
  foyers: Foyer[] = [];
  selectedFoyer: Foyer | null = null; // Stocke le foyer en cours d'édition
  showAddFoyerForm = false;
  newFoyer: Foyerr = { nomFoyer: '', capaciteFoyer: 0 }; // Définir newFoyer ici

  constructor(private foyerService: FoyerService) {}

  ngOnInit() {
    this.getFoyers();
  }

  getFoyers() {
    this.foyerService.getFoyers().subscribe((data) => {
      this.foyers = data;
    });
  }

  editFoyer(foyer: Foyer) {
    this.selectedFoyer = { ...foyer }; // Cloner pour éviter les modifications directes
  }

  updateFoyer() {
    if (this.selectedFoyer) {
      this.foyerService.updateFoyer(this.selectedFoyer).subscribe(() => {
        this.getFoyers(); // Rafraîchir la liste
        this.selectedFoyer = null; // Réinitialiser
      });
    }
  }

  cancelEdit() {
    this.selectedFoyer = null; // Masquer le formulaire
  }

  deleteFoyer(idFoyer: number) {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce foyer ?')) {
      this.foyerService.deleteFoyer(idFoyer).subscribe(() => {
        // After deletion, refresh the list of foyers
        this.getFoyers();
      });
    }
  }


  addFoyer() {
    if (this.newFoyer.nomFoyer && this.newFoyer.capaciteFoyer) {
      console.log('Adding new foyer:', this.newFoyer);
      console.log('Foyer data:', this.newFoyer);
      this.foyerService.addFoyer(this.newFoyer).subscribe(() => {
        this.getFoyers();
        this.showAddFoyerForm = false; 
        this.newFoyer = { nomFoyer: '', capaciteFoyer: 0 }; 
      });
    } else {
      alert('Veuillez remplir tous les champs!');
    }
  }

  cancelAdd() {
    this.showAddFoyerForm = false; 
    this.newFoyer = { nomFoyer: '', capaciteFoyer: 0 }; 
  }
}

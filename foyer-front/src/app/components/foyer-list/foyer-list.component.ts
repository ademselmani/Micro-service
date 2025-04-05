import { Component, OnInit } from '@angular/core';
import { FoyerService, Foyer, Foyerr } from '../../services/foyer.service';

@Component({
  selector: 'app-foyer-list',
  templateUrl: './foyer-list.component.html',
})
export class FoyerListComponent implements OnInit {
  foyers: Foyer[] = [];
  filteredFoyers: Foyer[] = [];
  selectedFoyer: Foyer | null = null;
  showAddFoyerForm = false;
  newFoyer: Foyerr = { nomFoyer: '', capaciteFoyer: 0 };
  searchTerm: string = '';

  // 🌙 Dark Mode State
  isDarkMode: boolean = false;

  constructor(private foyerService: FoyerService) {}

  ngOnInit() {
    this.getFoyers();

    // Restore dark mode from localStorage
    const savedTheme = localStorage.getItem('darkMode');
    this.isDarkMode = savedTheme === 'true';
  }

  // Toggle dark mode and persist preference
  toggleDarkMode() {
    this.isDarkMode = !this.isDarkMode;
    localStorage.setItem('darkMode', String(this.isDarkMode));
  }

  getFoyers() {
    this.foyerService.getFoyers().subscribe((data) => {
      this.foyers = data;
      this.filteredFoyers = data;
    });
  }

  filterFoyers() {
    const term = this.searchTerm.toLowerCase().trim();
    if (!term) {
      this.filteredFoyers = this.foyers;
    } else {
      this.filteredFoyers = this.foyers.filter((foyer) =>
        foyer.nomFoyer.toLowerCase().includes(term)
      );
    }
  }

  editFoyer(foyer: Foyer) {
    this.selectedFoyer = { ...foyer };
  }

  updateFoyer() {
    if (this.selectedFoyer) {
      this.foyerService.updateFoyer(this.selectedFoyer).subscribe(() => {
        this.getFoyers();
        this.selectedFoyer = null;
      });
    }
  }

  cancelEdit() {
    this.selectedFoyer = null;
  }

  deleteFoyer(idFoyer: number) {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce foyer ?')) {
      this.foyerService.deleteFoyer(idFoyer).subscribe(() => {
        this.getFoyers();
      });
    }
  }

  addFoyer() {
    if (this.newFoyer.nomFoyer && this.newFoyer.capaciteFoyer) {
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

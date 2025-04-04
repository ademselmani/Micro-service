// import { Component, OnInit } from '@angular/core';
// import { ActivatedRoute, Router } from '@angular/router';
// import { ApiService } from '../service/api.service';

// @Component({
//   selector: 'app-bloc-update',
//   templateUrl: './bloc-update.component.html',
//   styleUrls: ['./bloc-update.component.css']
// })
// export class BlocUpdateComponent implements OnInit {
//   bloc: any = { idBloc: null, nomBloc: '', capaciteBloc: '' };  // Initialisation du bloc
//   isLoading: boolean = true;  // Pour savoir si le bloc est en cours de chargement

//   constructor(
//     private apiService: ApiService,
//     private route: ActivatedRoute,
//     private router: Router
//   ) {}

//   ngOnInit(): void {
//     console.log('ngOnInit appelé');  // Log pour vérifier si le composant est bien initialisé
//     const blocId = this.route.snapshot.paramMap.get('id');

//     // Validation si blocId est bien un nombre
//     if (blocId && !isNaN(Number(blocId))) {
//       console.log('ID du bloc récupéré:', blocId);  // Log pour vérifier l'ID récupéré
//       this.getBlocById(blocId);
//     } else {
//       console.error('ID du bloc invalide ou manquant');
//       this.router.navigate(['/blocs']);  // Rediriger vers la page des blocs si l'ID est invalide
//     }
//   }

//   getBlocById(id: string): void {
//     console.log('Tentative de récupération du bloc avec ID:', id);  // Log pour vérifier l'ID passé
//     this.apiService.getBlocById(Number(id)).subscribe(
//       (data) => {
//         console.log('Données du bloc récupérées:', data);  // Log pour afficher les données récupérées
//         this.bloc = data;
//         this.isLoading = false;  // Chargement terminé
//       },
//       (error) => {
//         console.error('Erreur lors de la récupération du bloc:', error);
//         this.router.navigate(['/blocs']);  // Rediriger vers la page des blocs en cas d'erreur
//       }
//     );
//   }

//   updateBloc(): void {
//     console.log('Tentative de mise à jour du bloc:', this.bloc);  // Log pour vérifier les données du bloc avant la mise à jour
//     this.apiService.updateBloc(this.bloc).subscribe(
//       (response) => {
//         console.log('Bloc mis à jour avec succès', response);
//         this.router.navigate(['/blocs']);  // Redirige vers la liste des blocs après mise à jour
//       },
//       (error) => {
//         console.error('Erreur lors de la mise à jour du bloc', error);
//       }
//     );
//   }
// }

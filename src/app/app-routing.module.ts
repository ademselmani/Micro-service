import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BlocComponent } from './bloc/bloc.component';
import { BlocUpdateComponent } from './bloc-update/bloc-update.component';

const routes: Routes = [
  { path: 'blocs', component: BlocComponent },
  { path: 'update-bloc/:id', component: BlocUpdateComponent },
  { path: '', redirectTo: '/blocs', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private apiUrl = 'http://localhost:8089/microService/bloc'; // L'URL de votre backend

  constructor(private http: HttpClient) {}

  // Méthode pour récupérer tous les blocs
  getAllBlocs(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  // Méthode pour récupérer un bloc par son ID
  getBlocById(blocId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${blocId}`);
  }

  // Méthode pour ajouter un bloc
  addBloc(bloc: any): Observable<any> {
    return this.http.post(this.apiUrl, bloc);
  }

  // Méthode pour mettre à jour un bloc
  updateBloc(bloc: any): Observable<any> {
    return this.http.put(this.apiUrl, bloc);
  }

  // Méthode pour supprimer un bloc
  deleteBloc(blocId: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${blocId}`);
  }

  filterBlocs(nomBloc: string, capaciteBloc: string): Observable<any> {
    const params = new HttpParams()
      .set('nomBloc', nomBloc)
      .set('capaciteBloc', capaciteBloc);
    return this.http.get(`${this.apiUrl}/filter`, { params });
  }
  
}

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { BlocComponent } from './bloc/bloc.component';
import { FormsModule } from '@angular/forms';
import { BlocUpdateComponent } from './bloc-update/bloc-update.component';

@NgModule({
  declarations: [
    AppComponent,
    BlocComponent,
    BlocUpdateComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

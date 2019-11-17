import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StockCreateComponent } from './stock-create/stock-create.component';
import { StockComponent } from './stock/stock.component';
import { StockListComponent } from './stock-list/stock-list.component';
import { StockUpdateComponent } from './stock-update/stock-update.component';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    StockCreateComponent,
    StockComponent,
    StockListComponent,
    StockUpdateComponent
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

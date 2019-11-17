import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {StockCreateComponent} from './stock-create/stock-create.component';
import {StockComponent} from './stock/stock.component';
import {StockListComponent} from './stock-list/stock-list.component';
import {StockUpdateComponent} from './stock-update/stock-update.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'stocks'},
  {path: 'stocks', component: StockListComponent},
  {path: 'update-stock/:id', component: StockUpdateComponent},
  {path: 'create-stock', component: StockCreateComponent},
  {path: 'stock', component: StockComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

import { Component, OnInit } from '@angular/core';
import {StockService} from '../shared/stock.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-stock-update',
  templateUrl: './stock-update.component.html',
  styleUrls: ['./stock-update.component.css']
})
export class StockUpdateComponent implements OnInit {
  id = this.actRoute.snapshot.params.id;
  stockData: any = {};
  constructor( public stockService: StockService,
               public actRoute: ActivatedRoute,
               public router: Router) { }

  ngOnInit() {
   this.stockService.getStockById(this.id).subscribe((data: {}) => {
     this.stockData = data;
   });
  }

  updateStocks() {
    if (window.confirm( 'Do you want to update stock ?')) {
  return this.stockService.updateStock(this.stockData, this.id).subscribe((data: {}) => {
    this.router.navigate(['/stocks']);
  });
  }}

}

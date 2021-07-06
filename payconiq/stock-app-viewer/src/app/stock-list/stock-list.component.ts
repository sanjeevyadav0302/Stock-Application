import { Component, OnInit } from '@angular/core';
import {Stock} from '../shared/stock';
import {StockService} from '../shared/stock.service';

@Component({
  selector: 'app-stock-list',
  templateUrl: './stock-list.component.html',
  styleUrls: ['./stock-list.component.css']
})
export class StockListComponent implements OnInit {
  Stock: any = [];
  constructor( public stockService: StockService) { }

  ngOnInit() {
    this.loadStocks();
  }
   loadStocks() {
     return this.stockService.getStocks().subscribe((data: {}) => {
       this.Stock = data;
     });
  }
}

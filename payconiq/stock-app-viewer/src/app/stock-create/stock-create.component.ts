import { Component, OnInit } from '@angular/core';
import {StockService} from '../shared/stock.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-stock-create',
  templateUrl: './stock-create.component.html',
  styleUrls: ['./stock-create.component.css']
})
export class StockCreateComponent implements OnInit {
  stockData: any = {};
  constructor(public stockService: StockService,
              public actRoute: ActivatedRoute,
              public router: Router) { }

  ngOnInit() {
  }

  createStock() {
    return this.stockService.craeteStock(this.stockData).subscribe((data: {}) => {
      this.router.navigate(['/stocks']);
    });
  }
}

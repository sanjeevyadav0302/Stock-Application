import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, pipe, throwError} from 'rxjs';
import {Stock} from './stock';
import {catchError, retry} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  // apiURL = 'http://localhost:8080/api';
  private baseUrl = '/api';

  constructor(private http: HttpClient) {
  }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  // HttpClient API get() method => Fetch stock list
  getStocks(): Observable<Stock> {
    return this.http.get<Stock>(this.baseUrl + '/stocks')
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
  }

  getStockById(stockId): Observable<Stock> {
    return this.http.get<Stock>(this.baseUrl + '/stocks/' + stockId)
      .pipe(retry(1),
        catchError(this.handleError));
  }

  updateStock(stock, id): Observable<Stock> {
    console.log(JSON.stringify(stock));
    // const headers = new HttpHeaders({'Content-Type': 'application/json; charset=utf-8'});
    return this.http.put<Stock>(this.baseUrl + '/stocks/' + id, JSON.stringify(stock), this.httpOptions).pipe(retry(1),
      catchError(this.handleError));
  }

  craeteStock(stock): Observable<Stock> {
    // const headers = new HttpHeaders({'Content-Type': 'application/json; charset=utf-8'});
    return this.http.post<Stock>(this.baseUrl + '/stocks', JSON.stringify(stock), this.httpOptions).pipe(
      retry(1),
      catchError(this.handleError));
  }


  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }
}

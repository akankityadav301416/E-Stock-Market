import { Component, OnDestroy, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {
  BehaviorSubject,
  Observable,
  of,
  ReplaySubject,
  Subject,
  Subscription,
} from 'rxjs';
import { FormBuilder, FormGroup } from '@angular/forms';
import { stringify } from 'querystring';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit, OnDestroy {
  private corsHeaders: HttpHeaders;
  // orgSummary: any;
  // orgSummary: any;
  orgSummary$: Subject<any> = new BehaviorSubject(null);
  currentOrg$: Subject<any> = new BehaviorSubject(null);
  companyAdded: boolean = false;
  stockAdded: boolean = false;
  companyDeleted: boolean = false;
  constructor(
    private httpClient: HttpClient,
    private formBuilder: FormBuilder,
    public datepipe: DatePipe
  ) {
    this.corsHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Accept: 'application/json',
      'Access-Control-Allow-Origin':
        'http://ec2-34-228-73-192.compute-1.amazonaws.com:8080/',
    });
  }

  ngOnInit(): void {}
  urlCompany = 'http://ec2-34-228-73-192.compute-1.amazonaws.com:8080/';
  urlStock = 'http://ec2-107-20-30-210.compute-1.amazonaws.com:8080/';

  fetchCompanyDetails() {
    this.companyAdded = false;
    this.stockAdded = false;
    this.companyDeleted = false;
    this.orgSummary$.next();
    this.currentOrg$.next();
    this.httpClient
      .get(this.urlCompany + 'api/v1.0/market/company/getall')
      .subscribe((response) => {
        this.orgSummary$.next(response);
        console.log(response);
      });
  }

  companyAdd = this.formBuilder.group({
    companyCEO: '',
    companyCode: '',
    companyName: '',
    companyTurnover: '',
    companyWebsite: '',
    stockExchange: '',
  });

  stockAdd = this.formBuilder.group({
    companyCode: '',
    stockPrice: '',
  });

  companySearch = this.formBuilder.group({
    code: '',
  });

  companyDelete = this.formBuilder.group({
    code: '',
  });

  companyStockSearch = this.formBuilder.group({
    code: '',
    from_date: '',
    to_date: '',
  });

  onCompanyAdd(): void {
    this.companyAdded = true;
    this.stockAdded = false;
    this.companyDeleted = false;
    this.orgSummary$.next();
    this.currentOrg$.next([]);
    console.log(this.companyAdd.value);
    this.httpClient
      .post<any>(
        this.urlCompany + `api/v1.0/market/company/register`,
        this.companyAdd.value
      )
      .subscribe((response) => {
        // this.orgSummary$.next([response]);
        console.log(response);
      });
  }

  onCompanyDelete(): void {
    this.companyAdded = false;
    this.stockAdded = false;
    this.companyDeleted = true;
    this.orgSummary$.next();
    this.currentOrg$.next();
    console.log(this.companyDelete.value);
    this.httpClient
      .delete<any>(
        this.urlCompany +
          `api/v1.0/market/company/delete/${this.companyDelete.value.code}`,
        this.companyDelete.value
      )
      .subscribe((response) => {
        // this.orgSummary$.next([response]);
        console.log(response);
      });
  }

  onStockAdd(): void {
    this.companyAdded = false;
    this.stockAdded = true;
    this.companyDeleted = false;
    this.orgSummary$.next();
    this.currentOrg$.next();
    console.log(this.stockAdd.value);
    this.httpClient
      .post<any>(
        this.urlStock +
          `api/v1.0/market/stock/add/${this.stockAdd.value.companyCode}?stockPrice=${this.stockAdd.value.stockPrice}`,
        this.stockAdd.value.stockPrice
      )
      .subscribe((response) => {
        // this.orgSummary$.next([response]);
        console.log(response);
      });
  }

  onCompanySearch(): void {
    this.companyAdded = false;
    this.stockAdded = false;
    this.companyDeleted = false;
    this.orgSummary$.next([]);
    this.currentOrg$.next();
    this.httpClient
      .get(
        this.urlCompany +
          `api/v1.0/market/company/info/${this.companySearch.value.code}`
      )
      .subscribe((response) => {
        this.orgSummary$.next([response]);
        console.log(response);
      });
  }

  onStockSearch(): void {
    this.companyAdded = false;
    this.stockAdded = false;
    this.companyDeleted = false;
    this.orgSummary$.next();
    this.currentOrg$.next([]);
    let from_date = this.datepipe.transform(
      this.companyStockSearch.value.from_date,
      'dd-MM-yyyy'
    );
    let to_date = this.datepipe.transform(
      this.companyStockSearch.value.to_date,
      'dd-MM-yyyy'
    );
    this.httpClient
      .get(
        this.urlStock +
          `api/v1.0/market/stock/get/${this.companyStockSearch.value.code}/${from_date}/${to_date}`
      )
      .subscribe((response) => {
        this.currentOrg$.next(response);
        console.log(response);
      });
  }

  ngOnDestroy() {
    // cancel the subscriptions here
  }
}

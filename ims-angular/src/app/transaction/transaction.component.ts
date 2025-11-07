import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PaginationComponent } from "../pagination/pagination.component";

@Component({
  selector: 'app-transaction',
  standalone:true,
  imports: [CommonModule, FormsModule, PaginationComponent],
  templateUrl: './transaction.component.html',
  styleUrl: './transaction.component.css'
})
export class TransactionComponent implements OnInit{
  constructor(private apiService:ApiService , private router:Router){}

  transactions:any[]=[];
  message: string='';
  searchInput:string = '';
  valueToSearch: string = '';
  currentPage: number = 1;
  totalPages: number = 0;
  itemsPerPage: number = 10;

  ngOnInit(): void {
      this.loadTransactions();
  }

  loadTransactions(): void {
    const isAdmin = this.apiService.isAdmin();
    console.log("isAdmin:", isAdmin, "Role:", this.apiService.getFromStorageAndDecrypt("role"));
    const apiCall = isAdmin
      ? this.apiService.getAllTransactions(this.valueToSearch)
      : this.apiService.getMyTransactions(this.currentPage - 1, this.itemsPerPage, this.valueToSearch);

    apiCall.subscribe({
      next: (res: any) => {
        console.log("API Response:", res);
        this.transactions = res.transactions || [];
        this.totalPages = Math.ceil((res.totalElements || 0) / this.itemsPerPage);
      },
      error: (error) => {
        console.error("Error:", error);
        this.showMessage(
          error?.error?.message ||
          error?.message ||
          'Unable to get transactions: ' + error
        );
      },
    });
}

  //Handle Search
    handleSearch():void{
      this.currentPage = 1;
      this.valueToSearch = this.searchInput;
      this.loadTransactions()
    }

    //Navigate to Transactions Details 

  navigateToTransactionsDetailsPage(transactionId: string ):void{
    this.router.navigate([`/transaction/${transactionId}`])
  }

  onPageChange(page: number): void {
    this.currentPage = page;
    this.loadTransactions();
  }

  showMessage(message: string) {
    this.message = message;
    setTimeout(() => {
      this.message = '';
    }, 4000);
  }

}

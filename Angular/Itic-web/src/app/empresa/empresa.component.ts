import { Component, OnInit } from '@angular/core';
import { Observable, subscribeOn } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';


@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.css']
})
export class EmpresaComponent implements OnInit {

  empresas: any= []

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  buscarEmpresa(){
    this.buscarEmpresasServicio().subscribe((response:any) =>this.mostrarEmpresa(response));  
  }
  mostrarEmpresa(response:any){
    this.empresas = response;
  }
  buscarEmpresasServicio(): Observable<any> {
    return this.http.get<any>("http://localhost:8080/empresas")
      .pipe(
        catchError(error => {
          console.error('Error en la solicitud:', error);
          return [];
        })
      );
  }
}

import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PassDataService {
  private fin = new Subject<string>();

  sendFin(fin: string) {
    this.fin.next(fin);
  }

  getFin(): Observable<string> {
    return this.fin.asObservable();
  }

  constructor() { }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { RNS_PAY_TERMS_MASTER } from './rns-pay-terms-master.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<RNS_PAY_TERMS_MASTER>;

@Injectable()
export class RNS_PAY_TERMS_MASTERService {

    private resourceUrl =  SERVER_API_URL + 'api/rns-pay-terms-masters';

    constructor(private http: HttpClient) { }

    create(rNS_PAY_TERMS_MASTER: RNS_PAY_TERMS_MASTER): Observable<EntityResponseType> {
        const copy = this.convert(rNS_PAY_TERMS_MASTER);
        return this.http.post<RNS_PAY_TERMS_MASTER>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(rNS_PAY_TERMS_MASTER: RNS_PAY_TERMS_MASTER): Observable<EntityResponseType> {
        const copy = this.convert(rNS_PAY_TERMS_MASTER);
        return this.http.put<RNS_PAY_TERMS_MASTER>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<RNS_PAY_TERMS_MASTER>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<RNS_PAY_TERMS_MASTER[]>> {
        const options = createRequestOption(req);
        return this.http.get<RNS_PAY_TERMS_MASTER[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<RNS_PAY_TERMS_MASTER[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: RNS_PAY_TERMS_MASTER = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<RNS_PAY_TERMS_MASTER[]>): HttpResponse<RNS_PAY_TERMS_MASTER[]> {
        const jsonResponse: RNS_PAY_TERMS_MASTER[] = res.body;
        const body: RNS_PAY_TERMS_MASTER[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to RNS_PAY_TERMS_MASTER.
     */
    private convertItemFromServer(rNS_PAY_TERMS_MASTER: RNS_PAY_TERMS_MASTER): RNS_PAY_TERMS_MASTER {
        const copy: RNS_PAY_TERMS_MASTER = Object.assign({}, rNS_PAY_TERMS_MASTER);
        return copy;
    }

    /**
     * Convert a RNS_PAY_TERMS_MASTER to a JSON which can be sent to the server.
     */
    private convert(rNS_PAY_TERMS_MASTER: RNS_PAY_TERMS_MASTER): RNS_PAY_TERMS_MASTER {
        const copy: RNS_PAY_TERMS_MASTER = Object.assign({}, rNS_PAY_TERMS_MASTER);
        return copy;
    }
}

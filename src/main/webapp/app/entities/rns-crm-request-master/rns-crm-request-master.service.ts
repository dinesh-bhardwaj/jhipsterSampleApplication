import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { RNS_CRM_REQUEST_MASTER } from './rns-crm-request-master.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<RNS_CRM_REQUEST_MASTER>;

@Injectable()
export class RNS_CRM_REQUEST_MASTERService {

    private resourceUrl =  SERVER_API_URL + 'api/rns-crm-request-masters';

    constructor(private http: HttpClient) { }

    create(rNS_CRM_REQUEST_MASTER: RNS_CRM_REQUEST_MASTER): Observable<EntityResponseType> {
        const copy = this.convert(rNS_CRM_REQUEST_MASTER);
        return this.http.post<RNS_CRM_REQUEST_MASTER>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(rNS_CRM_REQUEST_MASTER: RNS_CRM_REQUEST_MASTER): Observable<EntityResponseType> {
        const copy = this.convert(rNS_CRM_REQUEST_MASTER);
        return this.http.put<RNS_CRM_REQUEST_MASTER>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<RNS_CRM_REQUEST_MASTER>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<RNS_CRM_REQUEST_MASTER[]>> {
        const options = createRequestOption(req);
        return this.http.get<RNS_CRM_REQUEST_MASTER[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<RNS_CRM_REQUEST_MASTER[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: RNS_CRM_REQUEST_MASTER = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<RNS_CRM_REQUEST_MASTER[]>): HttpResponse<RNS_CRM_REQUEST_MASTER[]> {
        const jsonResponse: RNS_CRM_REQUEST_MASTER[] = res.body;
        const body: RNS_CRM_REQUEST_MASTER[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to RNS_CRM_REQUEST_MASTER.
     */
    private convertItemFromServer(rNS_CRM_REQUEST_MASTER: RNS_CRM_REQUEST_MASTER): RNS_CRM_REQUEST_MASTER {
        const copy: RNS_CRM_REQUEST_MASTER = Object.assign({}, rNS_CRM_REQUEST_MASTER);
        return copy;
    }

    /**
     * Convert a RNS_CRM_REQUEST_MASTER to a JSON which can be sent to the server.
     */
    private convert(rNS_CRM_REQUEST_MASTER: RNS_CRM_REQUEST_MASTER): RNS_CRM_REQUEST_MASTER {
        const copy: RNS_CRM_REQUEST_MASTER = Object.assign({}, rNS_CRM_REQUEST_MASTER);
        return copy;
    }
}

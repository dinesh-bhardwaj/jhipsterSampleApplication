import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { RNS_PCH_MASTER } from './rns-pch-master.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<RNS_PCH_MASTER>;

@Injectable()
export class RNS_PCH_MASTERService {

    private resourceUrl =  SERVER_API_URL + 'api/rns-pch-masters';

    constructor(private http: HttpClient) { }

    create(rNS_PCH_MASTER: RNS_PCH_MASTER): Observable<EntityResponseType> {
        const copy = this.convert(rNS_PCH_MASTER);
        return this.http.post<RNS_PCH_MASTER>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(rNS_PCH_MASTER: RNS_PCH_MASTER): Observable<EntityResponseType> {
        const copy = this.convert(rNS_PCH_MASTER);
        return this.http.put<RNS_PCH_MASTER>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<RNS_PCH_MASTER>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<RNS_PCH_MASTER[]>> {
        const options = createRequestOption(req);
        return this.http.get<RNS_PCH_MASTER[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<RNS_PCH_MASTER[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: RNS_PCH_MASTER = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<RNS_PCH_MASTER[]>): HttpResponse<RNS_PCH_MASTER[]> {
        const jsonResponse: RNS_PCH_MASTER[] = res.body;
        const body: RNS_PCH_MASTER[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to RNS_PCH_MASTER.
     */
    private convertItemFromServer(rNS_PCH_MASTER: RNS_PCH_MASTER): RNS_PCH_MASTER {
        const copy: RNS_PCH_MASTER = Object.assign({}, rNS_PCH_MASTER);
        return copy;
    }

    /**
     * Convert a RNS_PCH_MASTER to a JSON which can be sent to the server.
     */
    private convert(rNS_PCH_MASTER: RNS_PCH_MASTER): RNS_PCH_MASTER {
        const copy: RNS_PCH_MASTER = Object.assign({}, rNS_PCH_MASTER);
        return copy;
    }
}

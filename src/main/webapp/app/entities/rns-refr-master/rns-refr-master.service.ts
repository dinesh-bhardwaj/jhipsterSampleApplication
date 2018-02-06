import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { JhiDateUtils } from 'ng-jhipster';

import { RNS_REFR_MASTER } from './rns-refr-master.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<RNS_REFR_MASTER>;

@Injectable()
export class RNS_REFR_MASTERService {

    private resourceUrl =  SERVER_API_URL + 'api/rns-refr-masters';

    constructor(private http: HttpClient, private dateUtils: JhiDateUtils) { }

    create(rNS_REFR_MASTER: RNS_REFR_MASTER): Observable<EntityResponseType> {
        const copy = this.convert(rNS_REFR_MASTER);
        return this.http.post<RNS_REFR_MASTER>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(rNS_REFR_MASTER: RNS_REFR_MASTER): Observable<EntityResponseType> {
        const copy = this.convert(rNS_REFR_MASTER);
        return this.http.put<RNS_REFR_MASTER>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<RNS_REFR_MASTER>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<RNS_REFR_MASTER[]>> {
        const options = createRequestOption(req);
        return this.http.get<RNS_REFR_MASTER[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<RNS_REFR_MASTER[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: RNS_REFR_MASTER = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<RNS_REFR_MASTER[]>): HttpResponse<RNS_REFR_MASTER[]> {
        const jsonResponse: RNS_REFR_MASTER[] = res.body;
        const body: RNS_REFR_MASTER[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to RNS_REFR_MASTER.
     */
    private convertItemFromServer(rNS_REFR_MASTER: RNS_REFR_MASTER): RNS_REFR_MASTER {
        const copy: RNS_REFR_MASTER = Object.assign({}, rNS_REFR_MASTER);
        copy.cREATEDDATE = this.dateUtils
            .convertDateTimeFromServer(rNS_REFR_MASTER.cREATEDDATE);
        copy.lASTMODIFIEDDATE = this.dateUtils
            .convertDateTimeFromServer(rNS_REFR_MASTER.lASTMODIFIEDDATE);
        return copy;
    }

    /**
     * Convert a RNS_REFR_MASTER to a JSON which can be sent to the server.
     */
    private convert(rNS_REFR_MASTER: RNS_REFR_MASTER): RNS_REFR_MASTER {
        const copy: RNS_REFR_MASTER = Object.assign({}, rNS_REFR_MASTER);

        copy.cREATEDDATE = this.dateUtils.toDate(rNS_REFR_MASTER.cREATEDDATE);

        copy.lASTMODIFIEDDATE = this.dateUtils.toDate(rNS_REFR_MASTER.lASTMODIFIEDDATE);
        return copy;
    }
}

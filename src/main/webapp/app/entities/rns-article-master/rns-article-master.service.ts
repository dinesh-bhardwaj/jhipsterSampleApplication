import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { RNS_ARTICLE_MASTER } from './rns-article-master.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<RNS_ARTICLE_MASTER>;

@Injectable()
export class RNS_ARTICLE_MASTERService {

    private resourceUrl =  SERVER_API_URL + 'api/rns-article-masters';

    constructor(private http: HttpClient) { }

    create(rNS_ARTICLE_MASTER: RNS_ARTICLE_MASTER): Observable<EntityResponseType> {
        const copy = this.convert(rNS_ARTICLE_MASTER);
        return this.http.post<RNS_ARTICLE_MASTER>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(rNS_ARTICLE_MASTER: RNS_ARTICLE_MASTER): Observable<EntityResponseType> {
        const copy = this.convert(rNS_ARTICLE_MASTER);
        return this.http.put<RNS_ARTICLE_MASTER>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<RNS_ARTICLE_MASTER>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<RNS_ARTICLE_MASTER[]>> {
        const options = createRequestOption(req);
        return this.http.get<RNS_ARTICLE_MASTER[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<RNS_ARTICLE_MASTER[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: RNS_ARTICLE_MASTER = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<RNS_ARTICLE_MASTER[]>): HttpResponse<RNS_ARTICLE_MASTER[]> {
        const jsonResponse: RNS_ARTICLE_MASTER[] = res.body;
        const body: RNS_ARTICLE_MASTER[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to RNS_ARTICLE_MASTER.
     */
    private convertItemFromServer(rNS_ARTICLE_MASTER: RNS_ARTICLE_MASTER): RNS_ARTICLE_MASTER {
        const copy: RNS_ARTICLE_MASTER = Object.assign({}, rNS_ARTICLE_MASTER);
        return copy;
    }

    /**
     * Convert a RNS_ARTICLE_MASTER to a JSON which can be sent to the server.
     */
    private convert(rNS_ARTICLE_MASTER: RNS_ARTICLE_MASTER): RNS_ARTICLE_MASTER {
        const copy: RNS_ARTICLE_MASTER = Object.assign({}, rNS_ARTICLE_MASTER);
        return copy;
    }
}

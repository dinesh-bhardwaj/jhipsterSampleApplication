/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_ARTICLE_MASTERComponent } from '../../../../../../main/webapp/app/entities/rns-article-master/rns-article-master.component';
import { RNS_ARTICLE_MASTERService } from '../../../../../../main/webapp/app/entities/rns-article-master/rns-article-master.service';
import { RNS_ARTICLE_MASTER } from '../../../../../../main/webapp/app/entities/rns-article-master/rns-article-master.model';

describe('Component Tests', () => {

    describe('RNS_ARTICLE_MASTER Management Component', () => {
        let comp: RNS_ARTICLE_MASTERComponent;
        let fixture: ComponentFixture<RNS_ARTICLE_MASTERComponent>;
        let service: RNS_ARTICLE_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_ARTICLE_MASTERComponent],
                providers: [
                    RNS_ARTICLE_MASTERService
                ]
            })
            .overrideTemplate(RNS_ARTICLE_MASTERComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_ARTICLE_MASTERComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_ARTICLE_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_ARTICLE_MASTER(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_ARTICLE_MASTERS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});

/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_ARTICLE_MASTERDetailComponent } from '../../../../../../main/webapp/app/entities/rns-article-master/rns-article-master-detail.component';
import { RNS_ARTICLE_MASTERService } from '../../../../../../main/webapp/app/entities/rns-article-master/rns-article-master.service';
import { RNS_ARTICLE_MASTER } from '../../../../../../main/webapp/app/entities/rns-article-master/rns-article-master.model';

describe('Component Tests', () => {

    describe('RNS_ARTICLE_MASTER Management Detail Component', () => {
        let comp: RNS_ARTICLE_MASTERDetailComponent;
        let fixture: ComponentFixture<RNS_ARTICLE_MASTERDetailComponent>;
        let service: RNS_ARTICLE_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_ARTICLE_MASTERDetailComponent],
                providers: [
                    RNS_ARTICLE_MASTERService
                ]
            })
            .overrideTemplate(RNS_ARTICLE_MASTERDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_ARTICLE_MASTERDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_ARTICLE_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_ARTICLE_MASTER(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_ARTICLE_MASTER).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});

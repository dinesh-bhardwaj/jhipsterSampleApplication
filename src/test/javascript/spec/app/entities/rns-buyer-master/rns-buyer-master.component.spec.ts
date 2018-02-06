/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_BUYER_MASTERComponent } from '../../../../../../main/webapp/app/entities/rns-buyer-master/rns-buyer-master.component';
import { RNS_BUYER_MASTERService } from '../../../../../../main/webapp/app/entities/rns-buyer-master/rns-buyer-master.service';
import { RNS_BUYER_MASTER } from '../../../../../../main/webapp/app/entities/rns-buyer-master/rns-buyer-master.model';

describe('Component Tests', () => {

    describe('RNS_BUYER_MASTER Management Component', () => {
        let comp: RNS_BUYER_MASTERComponent;
        let fixture: ComponentFixture<RNS_BUYER_MASTERComponent>;
        let service: RNS_BUYER_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_BUYER_MASTERComponent],
                providers: [
                    RNS_BUYER_MASTERService
                ]
            })
            .overrideTemplate(RNS_BUYER_MASTERComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_BUYER_MASTERComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_BUYER_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_BUYER_MASTER(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_BUYER_MASTERS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});

/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_PAY_TERMS_MASTERComponent } from '../../../../../../main/webapp/app/entities/rns-pay-terms-master/rns-pay-terms-master.component';
import { RNS_PAY_TERMS_MASTERService } from '../../../../../../main/webapp/app/entities/rns-pay-terms-master/rns-pay-terms-master.service';
import { RNS_PAY_TERMS_MASTER } from '../../../../../../main/webapp/app/entities/rns-pay-terms-master/rns-pay-terms-master.model';

describe('Component Tests', () => {

    describe('RNS_PAY_TERMS_MASTER Management Component', () => {
        let comp: RNS_PAY_TERMS_MASTERComponent;
        let fixture: ComponentFixture<RNS_PAY_TERMS_MASTERComponent>;
        let service: RNS_PAY_TERMS_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_PAY_TERMS_MASTERComponent],
                providers: [
                    RNS_PAY_TERMS_MASTERService
                ]
            })
            .overrideTemplate(RNS_PAY_TERMS_MASTERComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_PAY_TERMS_MASTERComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_PAY_TERMS_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_PAY_TERMS_MASTER(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_PAY_TERMS_MASTERS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});

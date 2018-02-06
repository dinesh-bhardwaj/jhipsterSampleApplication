/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_PAY_TERMS_MASTERDetailComponent } from '../../../../../../main/webapp/app/entities/rns-pay-terms-master/rns-pay-terms-master-detail.component';
import { RNS_PAY_TERMS_MASTERService } from '../../../../../../main/webapp/app/entities/rns-pay-terms-master/rns-pay-terms-master.service';
import { RNS_PAY_TERMS_MASTER } from '../../../../../../main/webapp/app/entities/rns-pay-terms-master/rns-pay-terms-master.model';

describe('Component Tests', () => {

    describe('RNS_PAY_TERMS_MASTER Management Detail Component', () => {
        let comp: RNS_PAY_TERMS_MASTERDetailComponent;
        let fixture: ComponentFixture<RNS_PAY_TERMS_MASTERDetailComponent>;
        let service: RNS_PAY_TERMS_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_PAY_TERMS_MASTERDetailComponent],
                providers: [
                    RNS_PAY_TERMS_MASTERService
                ]
            })
            .overrideTemplate(RNS_PAY_TERMS_MASTERDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_PAY_TERMS_MASTERDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_PAY_TERMS_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_PAY_TERMS_MASTER(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_PAY_TERMS_MASTER).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});

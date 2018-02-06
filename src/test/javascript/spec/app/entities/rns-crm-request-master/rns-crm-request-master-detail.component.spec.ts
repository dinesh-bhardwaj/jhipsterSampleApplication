/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_CRM_REQUEST_MASTERDetailComponent } from '../../../../../../main/webapp/app/entities/rns-crm-request-master/rns-crm-request-master-detail.component';
import { RNS_CRM_REQUEST_MASTERService } from '../../../../../../main/webapp/app/entities/rns-crm-request-master/rns-crm-request-master.service';
import { RNS_CRM_REQUEST_MASTER } from '../../../../../../main/webapp/app/entities/rns-crm-request-master/rns-crm-request-master.model';

describe('Component Tests', () => {

    describe('RNS_CRM_REQUEST_MASTER Management Detail Component', () => {
        let comp: RNS_CRM_REQUEST_MASTERDetailComponent;
        let fixture: ComponentFixture<RNS_CRM_REQUEST_MASTERDetailComponent>;
        let service: RNS_CRM_REQUEST_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_CRM_REQUEST_MASTERDetailComponent],
                providers: [
                    RNS_CRM_REQUEST_MASTERService
                ]
            })
            .overrideTemplate(RNS_CRM_REQUEST_MASTERDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_CRM_REQUEST_MASTERDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_CRM_REQUEST_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_CRM_REQUEST_MASTER(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_CRM_REQUEST_MASTER).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});

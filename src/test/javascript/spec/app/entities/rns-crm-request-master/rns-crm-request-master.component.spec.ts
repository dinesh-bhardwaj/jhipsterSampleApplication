/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_CRM_REQUEST_MASTERComponent } from '../../../../../../main/webapp/app/entities/rns-crm-request-master/rns-crm-request-master.component';
import { RNS_CRM_REQUEST_MASTERService } from '../../../../../../main/webapp/app/entities/rns-crm-request-master/rns-crm-request-master.service';
import { RNS_CRM_REQUEST_MASTER } from '../../../../../../main/webapp/app/entities/rns-crm-request-master/rns-crm-request-master.model';

describe('Component Tests', () => {

    describe('RNS_CRM_REQUEST_MASTER Management Component', () => {
        let comp: RNS_CRM_REQUEST_MASTERComponent;
        let fixture: ComponentFixture<RNS_CRM_REQUEST_MASTERComponent>;
        let service: RNS_CRM_REQUEST_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_CRM_REQUEST_MASTERComponent],
                providers: [
                    RNS_CRM_REQUEST_MASTERService
                ]
            })
            .overrideTemplate(RNS_CRM_REQUEST_MASTERComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_CRM_REQUEST_MASTERComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_CRM_REQUEST_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_CRM_REQUEST_MASTER(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_CRM_REQUEST_MASTERS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});

/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_REFR_DETAILSComponent } from '../../../../../../main/webapp/app/entities/rns-refr-details/rns-refr-details.component';
import { RNS_REFR_DETAILSService } from '../../../../../../main/webapp/app/entities/rns-refr-details/rns-refr-details.service';
import { RNS_REFR_DETAILS } from '../../../../../../main/webapp/app/entities/rns-refr-details/rns-refr-details.model';

describe('Component Tests', () => {

    describe('RNS_REFR_DETAILS Management Component', () => {
        let comp: RNS_REFR_DETAILSComponent;
        let fixture: ComponentFixture<RNS_REFR_DETAILSComponent>;
        let service: RNS_REFR_DETAILSService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_REFR_DETAILSComponent],
                providers: [
                    RNS_REFR_DETAILSService
                ]
            })
            .overrideTemplate(RNS_REFR_DETAILSComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_REFR_DETAILSComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_REFR_DETAILSService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_REFR_DETAILS(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_REFR_DETAILS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
